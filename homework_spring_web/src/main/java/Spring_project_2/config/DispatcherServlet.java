//package Spring_project_2.config;
//
//import Spring_project_2.controller.OrderController;
//import Spring_project_2.controller.PingController;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"Spring_project_2"})
//public class DispatcherServlet implements WebMvcConfigurer {
//
//    private final OrderController orderController;
//    private final PingController pingController;
//
//    public DispatcherServlet(OrderController orderController, PingController pingController) {
//        this.orderController = orderController;
//        this.pingController = pingController;
//    }
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/");
//        resolver.setSuffix(".html");
//        registry.viewResolver(resolver);
//    }
//
//    @Bean
//    public OrderController orderController() {
//        return orderController;
//    }
//
//    @Bean
//    public PingController pingController() {
//        return pingController;
//    }
//}