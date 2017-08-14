package raspberry.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages= {"raspberry.example.demo"})
public class RaspberryTestApplication {
	
	@Value("${dht11.pin}")
	private int pin;
	
	@Bean
	public TemHumSensor temHumSensor() {
		return new TemHumSensor(pin);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RaspberryTestApplication.class, args);
	}
}
