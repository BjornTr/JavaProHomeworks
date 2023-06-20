import org.hillel.client.generated.Order;
import org.hillel.client.generated.OrderService;
import org.hillel.client.generated.OrderServiceService;
import org.hillel.client.generated.Product;

public class Main {

    public static void main(String[] args) {

        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");


        OrderService service = new OrderServiceService().getOrderServicePort();

        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Product 1");
        product1.setCost(5.0);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Product 2");
        product2.setCost(15.0);

        Order order1 = new Order();
        order1.setId(1);
        order1.setDate(new org.hillel.client.generated.LocalDate());
        order1.setCost(10.0);
        order1.getProducts().add(product1);

        Order order2 = new Order();
        order2.setId(2);
        order2.setDate(new org.hillel.client.generated.LocalDate());
        order2.setCost(30.0);
        order2.getProducts().add(product1);
        order2.getProducts().add(product2);

        service.addOrder(order1);
        service.addOrder(order2);
    }
}
