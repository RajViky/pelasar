package org.logistic.pelasar.fi.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.logistic.pelasar.fi.dao.ProductDao;
import org.logistic.pelasar.fi.model.Product;
import org.logistic.pelasar.fi.service.ProductService;

@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	private ProductDao productDao = new ProductDao();
	ProductService productService = new ProductService();
	
	@GET
	@Path("/{productId}")
	public Product getProductById(@PathParam("productId") long id) {
		return productDao.getProductById(id);
	}
	
	@GET
	@Path("/all")
	public List<Product> getProducts() {
		return productDao.getAllProducts();
	}
	
	@POST
	public Product postProduct(Product product) {
		return productService.addProduct(product);
	}
	
	@PUT
	@Path("/{productId}")
	public Product updateProduct(@PathParam("productId") long id,Product product) {
		product.setId(id);
		return productService.updateProduct(product);
	}
	
	@DELETE
	@Path("/{productId}")
	public void deleteProduct(@PathParam("productId") long id) {
		productService.removeProduct(id);
	}
}