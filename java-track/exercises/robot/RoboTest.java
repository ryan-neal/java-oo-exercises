package robot;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoboTest {

	@Test
	public void testGetX() {
		Robot John = new Robot("John", 0, 0, 1);
		//Robot Paul = new Robot("Paul", 1, 0, 0, 1);
		assertEquals("The x position is incorrect", 0, John.getX(), .01);
	}
	
	@Test
	public void testGetY() {
		Robot John = new Robot("John", 0, 0, 1);
		//Robot Paul = new Robot("Paul", 1, 0, 0, 1);
		assertEquals("The y position is incorrect", 0, John.getY(), .01);
	}
	
	@Test
	public void testRotateRight() {
		Robot John = new Robot("John", 0, 0, 1);
		//Robot Paul = new Robot("Paul", 1, 0, 0, 1);
		John.rotateRight();
		assertEquals("The angle is incorrect", 270, John.getOrientation(), .01);
		John.rotateRight();
		assertEquals("The angle is incorrect", 180, John.getOrientation(), .01);
		John.rotateRight();
		assertEquals("The angle is incorrect", 90, John.getOrientation(), .01);
		John.rotateRight();
		assertEquals("The angle is incorrect", 0, John.getOrientation(), .01);
	}
	
	@Test
	public void testRotateLeft() {
		Robot John = new Robot("John", 0, 0, 1);
		//Robot Paul = new Robot("Paul", 1, 0, 0, 1);
		John.rotateLeft();
		assertEquals("The angle is incorrect", 90, John.getOrientation(), .01);
		John.rotateLeft();
		assertEquals("The angle is incorrect", 180, John.getOrientation(), .01);
		John.rotateLeft();
		assertEquals("The angle is incorrect", 270, John.getOrientation(), .01);
		John.rotateLeft();
		assertEquals("The angle is incorrect", 0, John.getOrientation(), .01);
	}
	
	@Test
	public void testMove() {
		Robot John = new Robot("John", 0, 0, 1);
		//Robot Paul = new Robot("Paul", 1, 0, 0, 1);
		John.move();
		assertEquals("The position is incorrect", 1, John.getX(), .01);
		John.rotateLeft();
		John.move();
		assertEquals("The position is incorrect", 1, John.getX(), .01);
		assertEquals("The position is incorrect", 1, John.getY(), .01);
	}
	
	@Test
	public void testDistance() {
		Robot John = new Robot("John", 0, 0, 1);
		Robot Paul = new Robot("Paul", 3, 4, 1);
		assertEquals("The distance is incorrect", 5, John.getDistance(Paul), .01);
	}
}
