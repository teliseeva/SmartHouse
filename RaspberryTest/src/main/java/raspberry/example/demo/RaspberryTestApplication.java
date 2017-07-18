package raspberry.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages= {"raspberry.example.demo"})
public class RaspberryTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaspberryTestApplication.class, args);
	}
}
