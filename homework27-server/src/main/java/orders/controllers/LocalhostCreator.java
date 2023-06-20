package orders.controllers;

import jakarta.xml.ws.Endpoint;
import orders.service.OrderService;

public class LocalhostCreator {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        String url = "http://localhost:8090/orders";
        Endpoint.publish(url, orderService);

        System.out.println("Web orders.service is running at: " + url);
    }
}