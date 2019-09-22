package ukr.sinoptik.pages.ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ukr.sinoptik.pages.CommonPage;
import ukr.sinoptik.pages.sinoptik.SinoptikPage;

public class UkrNetPage extends CommonPage {

    private static String pageUrl = "https://www.ukr.net/";

    public UkrNetPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//section[@class='favorites-block']//a[@class='a0']")
    private WebElement sinoptikLink;

    public void openUkrNetPage() {
        openPage(pageUrl);
    }

    public SinoptikPage clickOnSinoptikLink() {
        sinoptikLink.click();
        switchToTab(1);
        return new SinoptikPage(driver);
    }

}
