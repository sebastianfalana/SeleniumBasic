package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ex4_SliderTests extends TestBase {


    @Test
    public void shouldPushSlider() {

        driver.get("https://seleniumui.moderntester.pl/slider.php");
        WebElement slider = driver.findElement(By.cssSelector("#custom-handle"));

        for (int i = 0; i <= 50; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }

        for (int i = 0; i <= 20; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
    }

    @Test
    public void shouldPushSliderCoupleTimes() {
        driver.get("https://seleniumui.moderntester.pl/slider.php");
        moveSliderTo(Keys.ARROW_RIGHT,50);
        moveSliderTo(Keys.ARROW_LEFT,20);

    }

    public void moveSliderToRight(int Size) {
        WebElement slider = driver.findElement(By.cssSelector("#custom-handle"));
        for (int i = 0; i < Size; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public void moveSliderTo(int Size) {
        WebElement slider = driver.findElement(By.cssSelector("#custom-handle"));
        for (int i = 0; i < Size; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public void moveSliderTo(Keys side, int Size) {
        WebElement slider = driver.findElement(By.cssSelector("#custom-handle"));

        if (side.equals(Keys.ARROW_RIGHT)) {
            for (int i = 0; i < Size; i++) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            }
        } else {
            for (int i = 0; i < Size; i++) {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        }
    }
}
