package genericUtilities;

import java.util.Random;

import com.github.javafaker.Faker;
import com.github.javafaker.Number;

public class JavaUtil {
	public int getRandomNumber() {
		return new Random().nextInt(10000);
	}
	
	public Number getFakeNumber() {
		return new Faker().number();
	}
}
