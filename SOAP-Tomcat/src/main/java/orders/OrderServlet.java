package orders;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import orders.entity.Order;
import orders.entity.Product;
import orders.repository.OrderRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrderServlet extends HttpServlet {

    private OrderRepository orderRepository;

    @Override
    public void init() throws ServletException {
        orderRepository = new OrderRepository();
    }


//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idParameter = request.getParameter("id");
//
//        if (idParameter != null) {
//            int orderId = Integer.parseInt(idParameter);
//            Order order = orderRepository.getByID(orderId);
//
//            if (order != null) {
//                sendJsonResponse(response, order);
//            } else {
//                sendErrorResponse(response, HttpServletResponse.SC_NOT_FOUND);
//            }
//        } else {
//            List<Order> orders = orderRepository.getAllOrders();
//            sendJsonResponse(response, orders);
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("id"));

        LocalDate orderDate = LocalDate.parse(request.getParameter("date"));
        double orderCost = Double.parseDouble(request.getParameter("cost"));

        Order newOrder = new Order(orderId, orderDate, orderCost, new ArrayList<>());

        orderRepository.addOrder(newOrder);

        Order order = orderRepository.getByID(orderId);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Order Details</h1>");
        out.println("<p>Order ID: " + order.getId() + "</p>");
        out.println("<p>Order Date: " + order.getDate() + "</p>");
        out.println("<p>Order Cost: " + order.getCost() + "</p>");
        out.println("<p>Order Products:</p>");
        out.println("<ul>");
        for (Product product : order.getProducts()) {
            out.println("<li>" + product.getName() + " - " + product.getCost() + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderJson = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Order order = convertJsonToOrder(orderJson);
        orderRepository.addOrder(order);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    private void sendJsonResponse(HttpServletResponse response, Object data) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(data);
        out.print(json);
        out.flush();
    }

    private void sendErrorResponse(HttpServletResponse response, int statusCode) throws IOException {
        response.sendError(statusCode);
    }

    private Order convertJsonToOrder(String orderJson) {
        Gson gson = new Gson();
        return gson.fromJson(orderJson, Order.class);
    }
}