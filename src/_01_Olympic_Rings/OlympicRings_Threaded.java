package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot timmy = new Robot(700, 300);
		Robot tammy = new Robot(800, 300);
		Robot sammy = new Robot(900, 300);
		Robot lammy = new Robot(750, 350);
		Robot kammy = new Robot(850, 350);
		
		Thread r1 = new Thread(()->circle(timmy));
		Thread r2 = new Thread(()->circle(tammy));
		Thread r3 = new Thread(()->circle(sammy));
		Thread r4 = new Thread(()->circle(lammy));
		Thread r5 = new Thread(()->circle(kammy));
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
	}
	public static void circle(Robot hi) {
		hi.penDown();
		for(int i = 0; i < 360; i++) {
			hi.move(1);
			hi.turn(1);
		}
	}
}

