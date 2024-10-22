package demoqa_tests;

import org.testng.annotations.Test;

public class AlertTests extends BaseTest {

    @Test(groups = {"UI", "TC-12"})
    void alertTest() {
        helper.getBrowserManager().openURL("https://demoqa.com/alerts");
        webElementActions.click(demoqaPages.getAlertPage().alertButton);
        helper.getAlertHelper().acceptAlert();
    }
}
