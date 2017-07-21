package raspberry.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	public static class TemHumSensor{
		public long Temperature;
		public long Humidity;
	}
	
	@RequestMapping("/tempHum")
	 public TemHumSensor GetTemperature() {
		 TemHumSensor data = new TemHumSensor();
		 data.Temperature = Math.round(20 + Math.random()*10);
		 data.Humidity = Math.round(50 + Math.random()*10);
		 return data;
	 }	
}


