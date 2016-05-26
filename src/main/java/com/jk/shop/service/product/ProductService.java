/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:ProductService.java 
 * 包名:com.jk.shop.service.product 
 * 创建日期:2016年4月11日下午3:20:26 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.service.product;

import java.util.List;

import javax.jws.WebService;

import com.jk.shop.model.product.Product;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：ProductService    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月11日 下午3:20:26    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月11日 下午3:20:26    
 * 修改备注：       
 * @version </pre>    
 */
public interface ProductService {

	public void addProduct(Product product);
	
	public List<Product> findProductPageList(Product product);
	
	public long findProductListCount(Product product);

	/** <pre>deleteProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：于笑扬 yuxy123@gmail.com    
	 * 创建时间：2016年4月13日 下午2:05:32    
	 * 修改人：于笑扬 yuxy123@gmail.com     
	 * 修改时间：2016年4月13日 下午2:05:32    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	public void deleteProduct(int id);
	
	public Product findProductById(int id);
	
	public void updateProduct(Product product);

	/** <pre>deleteBatchProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：于笑扬 yuxy123@gmail.com    
	 * 创建时间：2016年4月13日 下午3:47:33    
	 * 修改人：于笑扬 yuxy123@gmail.com     
	 * 修改时间：2016年4月13日 下午3:47:33    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	public void deleteBatchProduct(String ids);
}
