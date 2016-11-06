package blogz;

import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;
import junit.framework.TestCase;

public class PostAndUserTest extends TestCase {

	@Test
	public void testCreateUser(){
		User bob = new User("Bobby", "Broccoli");
		User fran = new User("Franny", "Cheese");
		assertTrue(bob.getUserName() == "Bobby");
		//assertEquals(bob.getID(), 1, .01);
		assertTrue(fran.getUserName() == "Franny");
		//assertEquals(fran.getID(), 2, .01);
	}
	
	@Test
	public void testUniqueUsername(){
		assertFalse(User.isValidUsername("Bobby"));
		assertFalse(User.isValidUsername("Franny"));
		assertTrue(User.isValidUsername("Teddy"));
	}
	
	@Test
	public void testEquals(){
		
		
	}
	
	@Test 
	public void testCreatePost(){
		User jon = new User("Johnny", "Broccqi");
		Post post1 = new Post("The Art of War", "Lots and lots of stuff", jon);
		assertTrue(post1.getTitle() == "The Art of War");
		assertTrue(post1.getBody() == "Lots and lots of stuff");
		System.out.println(post1.getAuthor());
	}
	
	@Test
	public void testGetPostsByUser(){
		User jose = new User("Joses", "Broczoli");
		Post post2 = new Post("Harry Potter", "Just stuff", jose);
		Post post3 = new Post("The Great Gatsby", "Some more stuff", jose);
		System.out.println(Post.getPostsByUser(jose));
	}
}