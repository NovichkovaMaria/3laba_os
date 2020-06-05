import java.util.Random;

public class Main {
	static Random rand = new Random();

	public static void main(String[] args) {
		Memory memory = new Memory(256, 64);

		for (int i = 0; i < 20; i++) {
			memory.inputNumber(rand.nextInt(memory.getSize()));
		}
	}
}
