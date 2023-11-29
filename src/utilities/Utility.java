package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;

public class Utility extends BaseTest {

    public void fE(By by){
        driver.findElement(by);
    }

    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
}
