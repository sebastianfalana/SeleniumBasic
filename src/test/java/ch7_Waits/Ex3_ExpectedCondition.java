package ch7_Waits;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex3_ExpectedCondition extends TestBase {

    @Test
    public void shouldAddToBasket(){
        driver.get("http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product&id_lang=2");
        driver.findElement(By.cssSelector("button[class='btn btn-primary add-to-cart']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='btn btn-primary']"))).click();

        WebElement trashButton = driver.findElement(By.cssSelector(".remove-from-cart"));
        wait.until(ExpectedConditions.elementToBeClickable(trashButton)).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".remove-from-cart")));

        String msg = driver.findElement(By.cssSelector(".no-items")).getText();
        WebElement elementMsg = driver.findElement(By.cssSelector(".no-items"));
        wait.until(ExpectedConditions.attributeContains(elementMsg,"class", "no-items"));
        Assert.assertEquals(msg, "There are no more items in your cart");
    }
}
