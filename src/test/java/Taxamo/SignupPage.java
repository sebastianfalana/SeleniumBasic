package Taxamo;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SignupPage extends TestBase {

    @Test
    public void signupEmailAddress() {
        int emailLength = 10;

        driver.get("https://manage.uat.marketplace.npreprod.taxamo.com/auth.html?#self-signup/S1_MARKETPLACE_UAT");
        driver.findElement(By.cssSelector("#form-email")).sendKeys("sebastian+" + getRandomValue(emailLength) + "@taxamo.com");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        String alertMsg = driver.findElement(By.cssSelector("[class^='alert']")).getText();
        Assert.assertEquals("At the moment, we are only accepting sign-ups from United Kingdom (UK) established businesses.", alertMsg);
        System.out.println("Alert message = " + alertMsg);

    }

    public void fillAddressData() {

        String postalCode = "NW11 0PU";
        String city = "London";
        String subdivision = "London";

        driver.findElement(By.cssSelector("#form-registered-company-business-name")).sendKeys(new SignupPage().getRandomValue(10));
        driver.findElement(By.cssSelector("#form-registered-company-postal-address-line1")).sendKeys(new SignupPage().getRandomValue(10));
        driver.findElement(By.cssSelector("#form-registered-company-postal-code")).sendKeys(postalCode);
        driver.findElement(By.cssSelector("#form-registered-company-city")).sendKeys(city);
        driver.findElement(By.cssSelector("#form-registered-company-country-subdivision")).sendKeys(subdivision);

        Select selectCountry = new Select(driver.findElement(By.cssSelector("#form-registered-company-country")));
        selectCountry.selectByIndex(1);

        driver.findElement((By.cssSelector("[type='submit']"))).click();
        String currentStepMessage = driver.findElement(By.cssSelector(".current-step")).getText();

        Assert.assertEquals(currentStepMessage, "Accept the Terms of Service");
    }

    public String getRandomValue(int emailLength) {
        String randomString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        String name = "";
        for (int i = 0; i < emailLength; i++) {
            name = name + randomString.charAt(rnd.nextInt(randomString.length()));
        }
        System.out.println("Random String = " + name);
        return name;

    }

    @Test
    private void signupTest() {
        signupEmailAddress();
        fillAddressData();

    }

}
