package fit;
import java.util.ArrayList;
import java.util.List;
public class MyAppT {
    public boolean isLogedin = false;
	public static ArrayList<User> up=new ArrayList<User>();
    public List<String> usedEmails = new ArrayList<>();
    public String Username;
    public String Email;
    public String Role;
    public String Password;
    public String ConfirmPassword;

    // الرسالة الناتجة
    public String signupMessage;


	public MyAppT() {
		
		User u1= new User("haya","123");
		up.add(u1);
		this.isLogedin = false;
	}
}
