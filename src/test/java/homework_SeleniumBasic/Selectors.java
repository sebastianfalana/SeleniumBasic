package homework_SeleniumBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Selectors extends TestBase {

        WebElement signIn = driver.findElement(By.cssSelector(".user-info .hidden-sm-down"));
        WebElement createOne = driver.findElement(By.cssSelector(".no-account >a"));

        WebElement socialTitle = driver.findElement(By.cssSelector(".custom-radio input[value='1']"));
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        WebElement email = driver.findElement(By.cssSelector(".register-form input[name='email']"));
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement birthday = driver.findElement(By.cssSelector("input[name='birthday']"));
        WebElement customer_privacy = driver.findElement(By.cssSelector("input[name='customer_privacy']"));
        WebElement privatePolicy = driver.findElement(By.cssSelector("input[name='psgdpr']"));
        WebElement saveButton = driver.findElement(By.cssSelector("footer[class='form-footer clearfix'] button[type='submit']"));

        WebElement userName = driver.findElement(By.cssSelector(".account .hidden-sm-down"));

}
