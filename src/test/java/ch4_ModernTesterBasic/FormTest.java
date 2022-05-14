package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends TestBase {

    @Test
    public void shouldFillFormWIthSuccess(){
        driver.get("https://seleniumui.moderntester.pl/form.php");
        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");

        driver.findElement(By.id("inputLastName3")).sendKeys("Kowalski");
        driver.findElement(By.id("inputEmail3")).sendKeys("dsagfdhsaf@wp.pl");
        driver.findElement(By.id("inputAge3")).sendKeys("18");

        List<WebElement> genders = driver.findElements(By.name("gridRadiosSex"));
        genders.get(0).click();

        List<WebElement> yearOfExperience = driver.findElements(By.name("gridRadiosExperience"));
        yearOfExperience.get(5).click();

        List<WebElement> professions = driver.findElements(By.name("gridCheckboxProfession"));

        Assert.assertTrue(professions.size()>0);
        for (WebElement element :
                professions) {
            element.click();
        }

        Select continents = new Select(driver.findElement(By.id("selectContinents")));
        continents.selectByIndex(2);

        Select seleniumCommands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
//        seleniumCommands.selectByValue("navigation-commands");

        for (WebElement element :
                seleniumCommands.getOptions()) {
            element.click();
        }

        WebElement fileUpload = driver.findElement(By.id("chooseFile"));

        File fileToUpload = new File("src/main/resources/file.txt");
        fileUpload.sendKeys(fileToUpload.getAbsolutePath());

        driver.findElement(By.className("btn-primary")).click();


        String msg = driver.findElement(By.id("validator-message")).getText();
        Assert.assertEquals(msg, "Form send with success");
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomListIndex = rnd.nextInt(elements.size());
        return elements.get(randomListIndex);
    }


}
