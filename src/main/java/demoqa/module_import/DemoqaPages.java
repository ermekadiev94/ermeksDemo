package demoqa.module_import;

import demoqa.pages.*;
import org.testng.annotations.BeforeClass;

public class DemoqaPages {

    public TextBoxPage textBoxPage;
    public ButtonsPage buttonsPage;
    public BrowserWindowsPage browserWindowsPage;
    public AlertPage alertPage;
    public SelectMenuPage selectMenuPage;
    public FramesPage framesPage;


    public DemoqaPages() {
        textBoxPage = new TextBoxPage();
        buttonsPage = new ButtonsPage();
        browserWindowsPage = new BrowserWindowsPage();
        alertPage = new AlertPage();
        selectMenuPage = new SelectMenuPage();
        framesPage = new FramesPage();
    }

    public TextBoxPage getTextBoxPage() {
        return textBoxPage;
    }

    public ButtonsPage getButtonsPage() {
        return buttonsPage;
    }

    public BrowserWindowsPage getBrowserWindowsPage() {
        return browserWindowsPage;
    }

    public AlertPage getAlertPage() {
        return alertPage;
    }

    public SelectMenuPage getSelectMenuPage() {
        return selectMenuPage;
    }

    public FramesPage getFramesPage() {
        return framesPage;
    }
}
