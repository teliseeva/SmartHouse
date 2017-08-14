package raspberry.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@Autowired
	DHT11Manager sensor;

	@RequestMapping("/tempHum")

	public TemHumSensor GetTemperature() {
		 TemHumSensor data = sensor.getTemHum();
		 return data;
	 }
}
