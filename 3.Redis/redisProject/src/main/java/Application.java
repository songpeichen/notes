import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
