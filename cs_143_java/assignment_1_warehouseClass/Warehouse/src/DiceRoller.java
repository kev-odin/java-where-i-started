import java.util.Arrays;

public class DiceRoller {

	public static void main(String[] args) {
		Dice.Die cube = new Dice.Die(6);
		
		// Roll this die a bunch of times and see which numbers come up...
		int[] faceCount = new int[7];
		
		for (int i = 0; i < 100000; i++) {
			cube.roll();
			faceCount[cube.getFace()]++;
		}
		
		System.out.println(Arrays.toString(faceCount));
		
		
		// We'll start by rolling Craps dice (2 six sided dice)
		Dice craps = new Dice(2, 6);
		
		craps.roll();
		
		// Print out the two dice
		System.out.println(craps.getDieFace(0));
		System.out.println(craps.getDieFace(1));

	}

}
