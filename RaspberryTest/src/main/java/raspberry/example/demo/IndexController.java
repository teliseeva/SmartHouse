package raspberry.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@Autowired
	DHT11Driver sensor;
	
	@Autowired
	private TemHumSensor temHumSensor;

	@RequestMapping("/tempHum")

	public TemHumSensor GetTemperature() {
		 TemHumSensor data = sensor.getTemHum(temHumSensor);
		 return data;
	 }
}
