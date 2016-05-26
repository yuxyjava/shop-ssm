/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:ProductServiceImpl.java 
 * 包名:com.jk.shop.service.product 
 * 创建日期:2016年4月11日下午3:21:03 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.service.product;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.shop.dao.product.ProductDao;
import com.jk.shop.model.product.Product;
import com.jk.shop.model.product.ProductImage;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：ProductServiceImpl    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月11日 下午3:21:03    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月11日 下午3:21:03    
 * 修改备注：       
 * @version </pre>    
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductImageService productImageService;

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.product.ProductService#addProduct(com.jk.shop.model.product.Product)    
	 */
	@Override
	public void addProduct(Product product) {
		// 添加产品
		productDao.addProduct(product);
		// 添加产品子图
		String productImageUrls = product.getProductImageUrls();
		if (StringUtils.isNotEmpty(productImageUrls)) {
		  productImageUrls = productImageUrls.substring(1);
		  String[] productImageUrlArr = productImageUrls.split(",");
		  for (String productImageUrl : productImageUrlArr) {
			ProductImage productImage = new ProductImage();
			productImage.setPath(productImageUrl);
			productImage.setProductId(product.getId());
			productImageService.addProductImage(productImage);
		  }
		}
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.product.ProductService#findProductPageList(com.jk.shop.model.product.Product)    
	 */
	@Override
	public List<Product> findProductPageList(Product product) {
		List<Product> productList = productDao.findProductPageList(product);
		return productList;
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.product.ProductService#findProductListCount(com.jk.shop.model.product.Product)    
	 */
	@Override
	public long findProductListCount(Product product) {
		long productListCount = productDao.findProductListCount(product);
		return productListCount;
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.product.ProductService#deleteProduct(int)    
	 */
	@Override
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.product.ProductService#findProductById(int)    
	 */
	@Override
	public Product findProductById(int id) {
		Product product = productDao.findProductById(id);
		return product;
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.product.ProductService#updateProduct(com.jk.shop.model.product.Product)    
	 */
	@Override
	public void updateProduct(Product product) {
		// 更新产品信息
		productDao.updateProduct(product);
		//============================更新子图信息==============================
		// 1.删除现有的
		String deletedProductImages = product.getDeletedProductImages();
		if (StringUtils.isNotEmpty(deletedProductImages)) {
			deletedProductImages = deletedProductImages.substring(1);
			String[] deletedProductImageArr = deletedProductImages.split(";");
			for (String deletedProductImage : deletedProductImageArr) {
				String[] productImageArr = deletedProductImage.split(",");
				int id = Integer.parseInt(productImageArr[0]);
				String path = productImageArr[1];
				productImageService.deleteProductImage(id);
			}
		}
		// 2.增加新上传的
		String productImageUrls = product.getProductImageUrls();
		if (StringUtils.isNotEmpty(productImageUrls)) {
		  productImageUrls = productImageUrls.substring(1);
		  String[] productImageUrlArr = productImageUrls.split(",");
		  for (String productImageUrl : productImageUrlArr) {
			ProductImage productImage = new ProductImage();
			productImage.setPath(productImageUrl);
			productImage.setProductId(product.getId());
			productImageService.addProductImage(productImage);
		  }
		}
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.product.ProductService#deleteBatchProduct(java.lang.String)    
	 */
	@Override
	public void deleteBatchProduct(String ids) {
		if (null != ids && ids.length() > 0) {
			List<Integer> idList = new ArrayList<Integer>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			productDao.deleteBatchProduct(idList);
		}
		
		
	}

}
