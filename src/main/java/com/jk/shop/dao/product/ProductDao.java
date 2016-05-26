/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:ProductDao.java 
 * 包名:com.jk.shop.dao.product 
 * 创建日期:2016年4月11日下午3:22:01 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.dao.product;

import java.util.List;

import com.jk.shop.model.product.Product;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：ProductDao    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月11日 下午3:22:01    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月11日 下午3:22:01    
 * 修改备注：       
 * @version </pre>    
 */
public interface ProductDao {

	public void addProduct(Product product);
	
	public List<Product> findProductPageList(Product product);
	
	public long findProductListCount(Product product);

	/** <pre>deleteProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：于笑扬 yuxy123@gmail.com    
	 * 创建时间：2016年4月13日 下午2:06:09    
	 * 修改人：于笑扬 yuxy123@gmail.com     
	 * 修改时间：2016年4月13日 下午2:06:09    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	public void deleteProduct(int id);

	/** <pre>findProductById(这里用一句话描述这个方法的作用)   
	 * 创建人：于笑扬 yuxy123@gmail.com    
	 * 创建时间：2016年4月13日 下午2:48:40    
	 * 修改人：于笑扬 yuxy123@gmail.com     
	 * 修改时间：2016年4月13日 下午2:48:40    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	public Product findProductById(int id);

	/** <pre>updateProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：于笑扬 yuxy123@gmail.com    
	 * 创建时间：2016年4月13日 下午2:48:46    
	 * 修改人：于笑扬 yuxy123@gmail.com     
	 * 修改时间：2016年4月13日 下午2:48:46    
	 * 修改备注： 
	 * @param product</pre>    
	 */
	public void updateProduct(Product product);

	/** <pre>deleteBatchProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：于笑扬 yuxy123@gmail.com    
	 * 创建时间：2016年4月13日 下午3:49:56    
	 * 修改人：于笑扬 yuxy123@gmail.com     
	 * 修改时间：2016年4月13日 下午3:49:56    
	 * 修改备注： 
	 * @param idList</pre>    
	 */
	public void deleteBatchProduct(List<Integer> idList);
}
