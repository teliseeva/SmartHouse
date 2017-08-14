package raspberry.example.demo;

import lombok.Data;;

@Data
public class TemHumSensor{
	private float temperature;
	private float humidity;
	
	
	public TemHumSensor() {
		temperature = -1;
		humidity = -1;
	}
	
}

