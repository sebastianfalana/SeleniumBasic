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

}
