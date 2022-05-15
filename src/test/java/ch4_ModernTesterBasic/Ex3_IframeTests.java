package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Ex3_IframeTests extends TestBase {

    @Test
    public void shouldOpenFrame(){

        driver.get("https://seleniumui.moderntester.pl/iframes.php");

        driver.switchTo().frame("iframe1");
        String msg = "Seba";
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys(msg);
        driver.switchTo().defaultContent();

        driver.switchTo().frame("iframe2");
        String msgLogin = "rrr";
        driver.findElement(By.cssSelector("#inputLogin")).sendKeys(msgLogin);
        driver.switchTo().defaultContent();

    }
}
