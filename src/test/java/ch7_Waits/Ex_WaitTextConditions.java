package ch7_Waits;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex_WaitTextConditions extends TestBase {

    @Test
    public void shouldTextToBeAppeared(){
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        WebElement element = driver.findElement(By.cssSelector(".progress-label"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".progress-label"), "Complete!"));

    }

    @Test
    public void shouldTextAppearedTwo(){
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        WebElement element = driver.findElement(By.cssSelector(".progress-label"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(By.cssSelector(".ui-progressbar-complete"),"class","ui-progressbar-complete"));

    }

    @Test
    public void shouldTextAppeared(){
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        WebElement element = driver.findElement(By.cssSelector(".progress-label"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(element,"Complete!"));

    }
}
