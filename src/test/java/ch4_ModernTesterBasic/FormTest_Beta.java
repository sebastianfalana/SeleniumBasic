package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FormTest_Beta extends TestBase {

    @Test
    private void shouldFillForm(){
        driver.get("https://seleniumui.moderntester.pl/form.php");
        driver.findElement(By.cssSelector(".navbar-nav > .nav-ite")).click();
        driver.findElement(By.cssSelector("#form-item")).click();

        getRandomValue(driver.findElements(By.cssSelector("*[name='gridRadiosExperience']"))).click();

        List<WebElement> yearOfExperienceSelectors = driver.findElements(By.cssSelector("gridCheckboxProfession"));
        for (WebElement yoes: yearOfExperienceSelectors) {
            yoes.click();
        }

        List<WebElement> countries = driver.findElements(By.xpath("//div//select[@id='selectContinents']//option[position()>1]"));
        Select selectContinents = new Select(driver.findElement(By.cssSelector("#selectContinents")));
        selectContinents.selectByVisibleText(getRandomElement(countries));
    }

    private WebElement getRandomValue(List<WebElement> elements){
        return elements.get(new Random().nextInt(elements.size()));
    }

    public String getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomListIndex = rnd.nextInt(elements.size());
        System.out.println(elements.get(randomListIndex).getText());
        return elements.get(randomListIndex).getText();
    }

    private String getRandomSelectorName(List<WebElement> elements){
        return elements.get(new Random().nextInt(elements.size())).getText();
    }
}
