import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	
	public static void main(String args[]){
		String pattern = "[a-zA-Z][a-zA-Z0-9_-]{4,11}.";
		Pattern w = Pattern.compile(pattern);
		Matcher m = w.matcher("Wanda");
		boolean b = m.matches();
		System.out.println(b);
		
	}
}
