package demoqa_tests;

import demoqa.data.MockDataGenerator;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTest {


    @Test(groups = {"API", "TC-17"})
    void testTextBox() {
        driver.get("https://demoqa.com/text-box");
        demoqaPages.getTextBoxPage().inputUserName("John Doe")
                .inputUserEmail("john.doe@example.com")
                .inputCurrentAddress("Wall street 123")
                .inputPermanentAddress("Some permanent address")
                .submit();
    }

    @Test(groups = {"DB", "TC-18"})
    void testTextBox2() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");
        demoqaPages.getTextBoxPage().fillTextBoxForm(MockDataGenerator.randomTextBox());
        Thread.sleep(4000);
    }
}
