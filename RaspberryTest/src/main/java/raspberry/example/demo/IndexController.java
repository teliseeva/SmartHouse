package raspberry.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {	
	int DTH11pin = 14;
		
	 @RequestMapping("/tempHum")
	 public TemHumSensor GetTemperature() {
		 DHT11Manager sensor = new DHT11Manager();
		 TemHumSensor data = sensor.getTemperature(DTH11pin);
		 return data;
	 }	
}


