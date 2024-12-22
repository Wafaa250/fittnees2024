package fit;

import io.cucumber.java.en.Given;

public class CommonSteps {

    

    // خطوة مشتركة لإعداد بيانات البداية
    @Given("I have setup initial data")
    public void iHaveSetupInitialData() {
        System.out.println("Initial data setup.");
    }

    // خطوة مشتركة لتنظيف البيانات بعد الاختبار
    @Given("I clean up after test")
    public void iCleanUpAfterTest() {
        System.out.println("Test data cleaned up.");
    }
}
