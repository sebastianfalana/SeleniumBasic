package homework_SeleniumBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_Easier_Main extends TestBase {

    @Test
    public void shouldTextAppear() {

        driver.get("http://146.59.32.4/index.php?controller=authentication&create_account=1");
        driver.findElement(By.cssSelector(".custom-radio input[value='1']")).click();
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Maniek");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Walczewski");
        driver.findElement(By.cssSelector(".register-form input[name='email']")).sendKeys("Walczewski@wp.pl");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("blabla");
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("05/2/1989");
        driver.findElement(By.cssSelector("input[name='customer_privacy']")).click();
        driver.findElement(By.cssSelector("input[name='psgdpr']")).click();
        driver.findElement(By.cssSelector("footer[class='form-footer clearfix'] button[type='submit']")).click();

        String as = driver.findElement(By.cssSelector(".account .hidden-sm-down")).getText();

        Assert.assertEquals(as,"Maniek Walczewski");

    }
}
