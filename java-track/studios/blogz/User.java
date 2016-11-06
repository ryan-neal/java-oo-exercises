	package blogz;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User extends Entity{

	private String username;
	private String pwHash;
	private static final List<User> allUsers = new ArrayList<User>();
	
	public User(String username, String password) {
		super();		
		this.username =  "";
		this.pwHash = hashPassword(password);
		try {
			if (isValidUsername(username)){
				this.username = username;
			} else {
				throw new Exception("Invalid Username");
			}}
			catch (Exception e){
				System.out.println(e);
			}
		if (this.username != "" ){
			allUsers.add(this);
		}
	}
	
	public static boolean isValidUsername(String username) {
		// TODO Auto-generated method stub
		if (getUserNames().contains(username)){
			return false;
		}
		return Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", username);
	}

	private static String hashPassword(String password) {
		// no hashing algorithm implemented yet; we'll do this later
		return password;
	}
	
	public boolean isValidPassword(String password) {
		return this.pwHash.equals(hashPassword(password));
	}
	
	public String getUserName() {
		return username;
	}
	
	public static List<User> getAllUsers() {
		return allUsers;
	}
	
	public static List<String> getUserNames(){
		List<String> usernames = new ArrayList<String>();
		for (User user: allUsers){
			usernames.add(user.getUserName());
		}
		return usernames;
	}
	
	public void printUsers(){
		for (User user: allUsers){
			System.out.println(user.getUserName());
		}
	}
	
	public boolean equals(Object o) {
		
		// exact same object literal
		if (this == o)
			return true;
		
		// null check
		if (o == null)
			return false;
		
		// type and cast check
		if (getClass() != o.getClass())
			return false;
		
		// cast to User for field comparison
		User user = (User) o;
		
		return user.getUserName() == username;
	}
	
}
