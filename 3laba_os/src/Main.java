import java.util.Random;

public class Main {
	static Random rand = new Random();

	public static void main(String[] args) {
		Memory memory = new Memory(256, 64);

		int index = rand.nextInt(5);
		while (true) {
			if (index >= 0 && index < memory.getSize()) {
				memory.inputNumber(index);
			}
		}
	}
}
