package fit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps {
	public MyAppT obj;
	
	public loginsteps(MyAppT iobj) {
		super();
		this.obj = iobj;
	}
	
	@Given("I am not in system")
	public void iAmNotInSystem() {
	   
	   assertTrue(obj.isLogedin==false);	
	}
	@When("set username {string} and pass {string}")
	public void setUsernameAndPass(String user_name, String pass) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		boolean f=false;
		for (User u: obj.up) {
			
			if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
				f=true;
			}
		}
		
		assertTrue(f);
	}
	@Then("login succeed")
	public void loginSucceed() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	
	@Then("login failed")
	public void loginFailed() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		
		
	}
	
	@When("set invalid username {string} and pass {string}")
	public void setInvalidUsernameAndPass(String user_name, String pass) {
	    // Write code here that turns the phrase above into concrete actions
		boolean f=false;
		for (User u: obj.up) {
			
			if (user_name==u.getUser_name() && u.getPass()==pass) {
				f=true;
			}
		}
		
		assertFalse(f);
	}

}
