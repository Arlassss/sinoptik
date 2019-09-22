package ukr.sinoptik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class CommonPage {

    protected WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    protected void switchToTab(int tabNumber){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }
}
