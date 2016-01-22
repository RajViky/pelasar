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

import org.logistic.pelasar.fi.dao.OrderDao;
import org.logistic.pelasar.fi.model.Order;
import org.logistic.pelasar.fi.service.OrderService;

@Path("/order")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {
	
	private OrderDao orderDao = new OrderDao();
	OrderService orderService = new OrderService();
	
	@GET
	@Path("/{orderId}")
	public Order getOrderById(@PathParam("orderId") long id) {
		return orderDao.getOrderById(id);
	}
	
	@GET
	@Path("/all")
	public List<Order> getOrders() {
		return orderDao.getAllOrders();
	}
	
	@POST
	public Order postOrder(Order order) {
		return orderService.addOrder(order);
	}
	
	@PUT
	@Path("/{orderId}")
	public Order updateOrder(@PathParam("orderId") long id,Order order) {
		order.setId(id);
		return orderService.updateOrder(order);
	}
	
	@DELETE
	@Path("/{orderId}")
	public void deleteOrder(@PathParam("orderId") long id) {
		orderService.removeOrder(id);
	}
}