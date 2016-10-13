package robot;

public class Robot {
	private int xPosition;
	private int yPosition;
	private String name;
	private int orientation;
	private int speed;
	
	public Robot(String name, int x, int y, int speed){
		this.xPosition = x;
		this.yPosition = y;
		this.name = name;
		this.orientation = 0;
		this.speed = speed;
	}
	
	public int getX(){
		return this.xPosition;
	}
	
	public int getY(){
		return this.yPosition;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getOrientation(){
		return this.orientation;
	}
	
	public int getSpeed(){
		return this.speed;
	}
	
	public void printString(){
		String answer = String.format("%s is at (%d,%d) facing %d degrees", this.name, this.xPosition, this.yPosition, this.orientation);
		System.out.println(answer);
	}	
	public void rotateRight(){
		if (this.orientation >= 90){
			this.orientation -= 90;
		}
		else{
			this.orientation = 270;
		}
	}
	
	public void rotateLeft(){
		if (this.orientation < 270){
				this.orientation += 90;
		}
		else{
			this.orientation = 0;
		}
	}
	
	public void move(){
		if (this.orientation == 0){
			this.xPosition += this.speed;
		}
		else if (this.orientation == 90){
			this.yPosition += this.speed;
		}
		else if (this.orientation == 180){
			this.xPosition -= this.speed;
		}
		else if (this.orientation == 270){
			this.yPosition -= this.speed;
		}		
	}
	
	public double getDistance(Robot fred){
		double x = Math.abs(this.xPosition - fred.xPosition);
		double y = Math.abs(this.yPosition - fred.yPosition);
		double answer = (x*x)+(y*y);
		return Math.sqrt(answer);
	}
	
	public static void main(String[] args){
	Robot John = new Robot("John", 0, 0, 1);
	Robot Paul = new Robot("Paul", 1, 0, 1);
	Paul.move();
	Paul.rotateRight();
	Paul.move();
	Paul.printString();
	System.out.println(Paul.getOrientation());
	double x = John.getDistance(Paul);
	System.out.println(x);
	}
}
