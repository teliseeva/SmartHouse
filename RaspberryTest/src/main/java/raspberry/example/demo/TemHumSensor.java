package raspberry.example.demo;

import lombok.Data;;

@Data
public class TemHumSensor{
	private float temperature;
	private float humidity;
	
	private final int pin;
	
	
	public TemHumSensor(int pin) {
		
		this.pin = pin;
		temperature = -1;
		humidity = -1;
	}
	
}

