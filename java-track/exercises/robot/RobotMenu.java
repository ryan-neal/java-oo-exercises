package robot;

import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {
	private ArrayList<Robot> robots;
	private Scanner scanner;
	
	public RobotMenu(){
		this.robots = new ArrayList<Robot>();
		this.scanner = new Scanner(System.in);
	}
	
	public static void main(String[] args){
		int input = 0;
		RobotMenu menu = new RobotMenu();
		do {
			input = menu.startMenu();
			menu.processInput(input);
		} while (input != 6);
	}

	public int startMenu(){
		System.out.println("Welcome to the robot menu screen");
		System.out.println("1: Create a robot");
		System.out.println("2: Display a list of robots");
		System.out.println("3: Move a robot");
		System.out.println("4: Rotate a robot");
		System.out.println("5: Get the distance between two robots");
		System.out.println("6: Exit");
		int selection = scanner.nextInt();
		while (selection < 0 || selection > 6){
			System.out.println("Invalid selection. Please enter another integer: ");
			selection = scanner.nextInt();
		}
		return selection;
	}
	
	public void processInput(int selection){
		if (selection == 1){
			createRobot();
		}
		if (selection == 2){
			displayRobots();
		}
		
		if (selection == 3){
			displayRobots();
			Robot r = selectRobot();
			r.move();
		}
		if (selection == 4){
			displayRobots();
			Robot r = selectRobot();
			r.rotateLeft();
		}
		if (selection == 5){
			displayRobots();
			Robot r = selectRobot();
			Robot s = selectRobot();
			r.getDistance(s);
		}
		
	}
	
	private void displayRobots(){
		for (int i = 0; i< robots.size(); i++){
			System.out.println((i+ 1) + ":" + robots.get(i));
		}
	}
	
	private Robot selectRobot(){
		System.out.println("Select a robot");
		int selection = scanner.nextInt();
		while (selection < 1 || selection > robots.size()){
			System.out.println("Select a robot");
			selection = scanner.nextInt();
		}
		return robots.get(selection - 1);
	}
	
	private void createRobot(){
		System.out.println("What is the x position of your robot?");
		int xPos = scanner.nextInt();
		System.out.println("What is the y position of your robot?");
		int yPos = scanner.nextInt();
		System.out.println("What is the speed of your robot?");
		int speed = scanner.nextInt();
		while (speed < 0){
			System.out.println("Please enter a speed > 0");
			speed = scanner.nextInt();
		}
		System.out.println("What is your robot's name?");
		String name = scanner.next();
		robots.add (new Robot(name, xPos, yPos, speed));
	}
}