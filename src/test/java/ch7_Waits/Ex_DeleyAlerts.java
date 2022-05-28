package ch7_Waits;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex_DeleyAlerts extends TestBase {

    @Test
    public void shouldWaitForAlert(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        driver.findElement(By.cssSelector("#delayed-alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#delayed-alert-label"),"OK button pressed"));
        String msg = driver.findElement(By.cssSelector("#delayed-alert-label")).getText();
        Assert.assertEquals(msg,"OK button pressed");
    }
}
