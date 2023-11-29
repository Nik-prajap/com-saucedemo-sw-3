package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com";

    @Before
    public void openBrowserSetUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        sendTextToElement(By.cssSelector("input#user-name"),"standard_user");
        sendTextToElement(By.cssSelector("input#password"),"secret_sauce");

        fE(By.cssSelector("input[type='submit'][id='login-button']"));
        String expectedText = "Products";
        String actualTestElements = getTextFromElement(By.cssSelector(".title"));
        Assert.assertEquals("Products",expectedText,actualTestElements);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        sendTextToElement(By.cssSelector("input[placeholder='Username']"),"standard_user");
        sendTextToElement(By.cssSelector("input[placeholder='Password']"),"secret_sauce");
        clickOnElement(By.cssSelector("input#login-button"));

        List<WebElement> productsDisplayed = driver.findElements(By.xpath("//div[@class='inventory_item']"));                       //first item inspect and take Class
        int count = productsDisplayed.size();
        System.out.println("Number of items displayed in the page : " + count);

        List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='inventory_item_description']//div/a"));         //Traverse from the class
        for (WebElement products : productNames) {
            System.out.println(products.getText());
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
