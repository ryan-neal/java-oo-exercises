import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void testGetArea() {
		Rectangle rectangle1 = new Rectangle(3, 5);
		assertTrue(rectangle1.getArea() == 15);
	}
	
	@Test
	public void testIsSquare() {
		Rectangle rectangle1 = new Rectangle(3, 5);
		assertTrue(rectangle1.isSquare() == false);
		Rectangle rectangle2 = new Rectangle(3, 3);
		assertTrue(rectangle2.isSquare() == true);
	}
	
	@Test
	public void testIsSmaller() {
		Rectangle rectangle1 = new Rectangle(3, 5);
		Rectangle rectangle2 = new Rectangle(3, 3);
		assertTrue(rectangle1.isSmaller(rectangle2) == false);
	}
	

}
