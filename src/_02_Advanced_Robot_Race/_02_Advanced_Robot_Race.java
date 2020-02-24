package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class _02_Advanced_Robot_Race {
	static boolean race = true;
	// 1. make a main method
	public static void main(String[] args) {
		// 2. create an array of 5 robots.
		Robot[] robo = new Robot[9];
		// 3. use a for loop to initialize the robots.
		for (int i = 0; i < robo.length; i++) {
			robo[i] = new Robot();
			robo[i].setSpeed(100);
		}
		// 4. make each robot start at the bottom of the screen, side by side, facing up
		for (int i = 0; i < robo.length; i++) {
			robo[i].moveTo(i * 100 + 100, 500);
		}
		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.
		Thread[] hi = new Thread[9];
		
		for(int i = 0; i < hi.length; i++) {
			int j = i;
			hi[i] = new Thread(()-> moveRandom(robo[j]));
		}
		
		

		for(int i = 0; i < hi.length; i++) {
			hi[i].start();
		}
		
		
		// 6. use a while loop to repeat step 5 until a robot has reached the top of the
		// screen.
		
		// 7. declare that robot the winner and throw it a party!
		
		// 8. try different races with different amounts of robots.
	}
	public static void moveRandom(Robot hey) {
		while (race) {
			Random rand = new Random();
			hey.move(rand.nextInt(50));
				if (hey.getY() < 100) {
					race = false;
					break;
				}
		}
	}

}