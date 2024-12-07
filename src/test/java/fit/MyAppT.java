package fit;
import java.util.ArrayList;

public class MyAppT {
	public boolean isLogedin;
	public static ArrayList<User> up=new ArrayList<User>();
	

	public MyAppT() {
		
		User u1= new User("haya","123");
		up.add(u1);
		this.isLogedin = false;
	}
}
