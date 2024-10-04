package demoqa_tests;

import org.testng.annotations.Test;

import java.util.List;

import static demoqa.enums.OldStyleSelectMenuValues.GREEN;

public class SelectMenuTests extends BaseTest {

    @Test
    void selectMenuTest() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/select-menu");
        helper.getDropdownHelper().selectByText(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, GREEN.getColor());
        Thread.sleep(5000);
        List<String> colors = helper.getDropdownHelper().getAllDropdownValues(demoqaPages.getSelectMenuPage().oldStyleSelectMenu);
        for (String color : colors) {
            System.out.println(color);
        }

    }
}
