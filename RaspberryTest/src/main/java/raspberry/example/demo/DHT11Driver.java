package raspberry.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;

@Service
public class DHT11Driver {
	
	private static final int MAXTIMINGS = 85;
	private final int[] dht11_dat = { 0, 0, 0, 0, 0 };

	public DHT11Driver() {

		// setup wiringPi
		if (Gpio.wiringPiSetup() == -1) {
			System.out.println(" ==>> GPIO SETUP FAILED");
			return;
		}

		GpioUtil.export(3, GpioUtil.DIRECTION_OUT);
	}

	public TemHumSensor getTemHum(TemHumSensor sensor) {
		for (int i = 0; i < 100; i++) {
			float[] th = getTemperature(sensor.getPin());
			if (th != null) {
				sensor.setHumidity(th[0]);
				sensor.setTemperature(th[1]);
				return sensor;
			}
		}
		return sensor;
	}

	private float[] getTemperature(final int pin) {

		int laststate = Gpio.HIGH;
		int j = 0;
		dht11_dat[0] = dht11_dat[1] = dht11_dat[2] = dht11_dat[3] = dht11_dat[4] = 0;

		Gpio.pinMode(pin, Gpio.OUTPUT);
		Gpio.digitalWrite(pin, Gpio.LOW);
		Gpio.delay(18);

		Gpio.digitalWrite(pin, Gpio.HIGH);
		Gpio.pinMode(pin, Gpio.INPUT);

		for (int i = 0; i < MAXTIMINGS; i++) {
			int counter = 0;
			while (Gpio.digitalRead(pin) == laststate) {
				counter++;
				Gpio.delayMicroseconds(1);
				if (counter == 255) {
					break;
				}
			}

			laststate = Gpio.digitalRead(pin);

			if (counter == 255) {
				break;
			}

			/* ignore first 3 transitions */
			if (i >= 4 && i % 2 == 0) {
				/* shove each bit into the storage bytes */
				dht11_dat[j / 8] <<= 1;
				if (counter > 16) {
					dht11_dat[j / 8] |= 1;
				}
				j++;
			}
		}
		// check we read 40 bits (8bit x 5 ) + verify checksum in the last
		// byte
		if (j >= 40 && checkParity()) {
			float h = (float) ((dht11_dat[0] << 8) + dht11_dat[1]) / 10;
			if (h > 100) {
				h = dht11_dat[0]; // for DHT11
			}
			float c = (float) (((dht11_dat[2] & 0x7F) << 8) + dht11_dat[3]) / 10;
			if (c > 125) {
				c = dht11_dat[2]; // for DHT11
			}
			if ((dht11_dat[2] & 0x80) != 0) {
				c = -c;
			}
			float[] res = new float[2];
			res[0] = h;
			res[1] = c;
		}
		return null;
	}

	private boolean checkParity() {
		return dht11_dat[4] == (dht11_dat[0] + dht11_dat[1] + dht11_dat[2] + dht11_dat[3] & 0xFF);
	}

}
