package raspberry.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@RequestMapping("/temperature")
	 public long GetTemperature() {
		 return Math.round(20 + Math.random()*10);
	 }
	
	@RequestMapping("/humidity")
	 public long GetHumidity() {
		 return Math.round(50 + Math.random()*10);
	 }

}
