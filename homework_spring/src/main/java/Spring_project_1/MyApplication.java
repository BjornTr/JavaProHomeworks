package Spring_project_1;

import Spring_project_1.config.DatabaseConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        context.close();
    }
}
