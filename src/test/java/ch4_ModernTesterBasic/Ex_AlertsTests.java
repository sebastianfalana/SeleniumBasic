package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ex_AlertsTests extends TestBase {

    @BeforeMethod
    public void testSetup(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
    }

    @Test
    public void shouldAcceptAlert() {
        driver.findElement(By.cssSelector("#simple-alert")).click();
        driver.switchTo().alert().accept();

        String msg = driver.findElement(By.cssSelector("#simple-alert-label")).getText();
//        WebElement msg2 = driver.findElement(By.cssSelector(".content #simple-alert-label"));

        Assert.assertEquals(msg,"OK button pressed");
    }

    @Test
    public void shouldFillPromptAlert(){
        driver.findElement(By.cssSelector("#prompt-alert")).click();
        driver.switchTo().alert().sendKeys("Seba");
        driver.switchTo().alert().accept();

        String msg = driver.findElement(By.cssSelector("#prompt-label")).getText();

        Assert.assertEquals(msg,"Hello Seba! How are you today?");

    }

    @Test
    public void shouldDismissAlert(){
        driver.findElement(By.cssSelector("#confirm-alert")).click();
        driver.switchTo().alert().dismiss();

        String msg = driver.findElement(By.cssSelector("#confirm-label")).getText();

        Assert.assertEquals(msg,"You pressed Cancel!");

    }

}
