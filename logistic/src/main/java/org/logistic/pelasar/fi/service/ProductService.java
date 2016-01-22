package org.logistic.pelasar.fi.service;

import org.logistic.pelasar.fi.dao.ProductDao;
import org.logistic.pelasar.fi.model.Product;

public class ProductService {
	private ProductDao productDao = new ProductDao();
	
	public ProductService(){
	}
	
	public Product addProduct(Product product) {
		productDao.saveProduct(product);		
		return productDao.getProductById(product.getId());
	}
	
	public Product updateProduct(Product product){
		if(product.getId() <= 0){
			return null;
		}
		productDao.updateProduct(product);
		return product;
	}
	
	public void removeProduct(long id)	{
		productDao.removeProduct(id);
	}
}
