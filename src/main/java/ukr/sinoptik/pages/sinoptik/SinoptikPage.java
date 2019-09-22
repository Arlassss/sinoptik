package ukr.sinoptik.pages.sinoptik;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ukr.sinoptik.pages.CommonPage;

public class SinoptikPage extends CommonPage {

    public SinoptikPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@class = 'lSide']//*[@class='today-temp']")
    private WebElement todayTemperature;

    public String getTodayTemperature() {
        return todayTemperature.getText();
    }
}
