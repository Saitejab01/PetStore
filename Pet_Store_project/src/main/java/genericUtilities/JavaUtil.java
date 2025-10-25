package genericUtilities;

import java.util.Random;

public class JavaUtil {
	public int getRandomNumber() {
		return new Random().nextInt(10000);
	}
}
