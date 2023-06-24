package controller;

import entity.Order;
import service.OrderService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.UUID;

@Path("/orders")
@Produces("application/json")
@Consumes("application/json")
public class OrderController {

    private final OrderService orderService = new OrderService();

    @POST
    public Response addOrder(Order order) {
        return Response.status(Response.Status.CREATED)
                .entity(orderService.addOrder(order))
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        return Response.ok(orderService.getByID(id))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") UUID id) {
        orderService.deleteOrder(id);
        return Response.noContent().build();
    }

    @PUT
    public Response updateOrder(Order order) {
        return Response.ok(orderService.updateOrder(order))
                .build();
    }

    @GET
    public Response getAllOrders() {
        Map<UUID, Order> orders = orderService.getAllOrders();
        return Response.ok(orders)
                .build();
    }

    @DELETE
    public Response clear() {
        orderService.clear();
        return Response.noContent().build();
    }
}