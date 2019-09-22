package sinoptik;

import common.CommonTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ukr.sinoptik.pages.sinoptik.SinoptikPage;
import ukr.sinoptik.pages.ukrnet.UkrNetPage;

public class SinoptikTest extends CommonTest {

    @Test(priority = 5)
    public void checkTemperatureTest() {
        UkrNetPage ukrNetPage = new UkrNetPage(driver);

        ukrNetPage.openUkrNetPage();
        SinoptikPage sinoptikPage = ukrNetPage.clickOnSinoptikLink();
        String temperature = sinoptikPage.getTodayTemperature();

        Assert.assertEquals(temperature, "+10°C");
    }

}
