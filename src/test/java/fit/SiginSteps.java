package fit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import fit.SiginSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SiginSteps {

    private boolean ONtheLoginPage;
    private boolean clickButton;
    private boolean loginSuccessful;

    SiginSource log = new SiginSource();  // تأكد من أنك تستخدم المسار الصحيح للـ LoginSource


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // تم تحديد أن المستخدم على صفحة تسجيل الدخول
        ONtheLoginPage = true;
    }


    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        // تم محاكاة نقرة على زر الدخول
        clickButton = true;
    }

    @Then("the user should see an error message indicating incorrect credentials")
    public void the_user_should_see_an_error_message_indicating_incorrect_credentials() {
        assertFalse(loginSuccessful);
    }

    @When("the user leaves the username or password field empty")
    public void the_user_leaves_the_username_or_password_field_empty() {
        // محاكاة حالة عندما يترك المستخدم أحد الحقول فارغًا
        // يمكنك تنفيذ رمز التحقق هنا، مثل:
        // log.checkLoginValidInFile(null, null);
        // loginSuccessful = log.getFoundAccount();
    }

    @Then("the user should see an error message indicating that all fields are required")
    public void the_user_should_see_an_error_message_indicating_that_all_fields_are_required() {
        assertFalse(loginSuccessful);
    }

    @When("the user enters valid username and password {string}+{string}")
    public void the_user_enters_valid_username_and_password(String username, String password) {
        // تحقق من صحة البيانات المدخلة
        log.checkLoginValidInFile(username, password);
        loginSuccessful = log.getFoundAccount();  // إذا تم العثور على حساب
    }

    @When("the user enters an invalid username or password {string}+{string}")
    public void the_user_enters_invalid_username_or_password(String username, String password) {
        // تحقق من صحة البيانات المدخلة
        log.checkLoginValidInFile(username, password);
        loginSuccessful = log.getFoundAccount();  // إذا تم العثور على حساب
        log.setCheckValid(1);  // تعيين قيمة الخطأ أو التحقق من عدم الصلاحية
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        // تحقق من أن المستخدم تم توجيهه إلى لوحة التحكم
        assertTrue(log.getCheckValid() == 1);
    }
}
