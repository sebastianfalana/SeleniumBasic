package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex4_SliderTest_Beta extends TestBase {

    @Test
    public void shouldSliderBePushed(){
        driver.get("https://seleniumui.moderntester.pl/slider.php");

        Assert.assertEquals(getcurrentSliderValue(),0);

        moveSlider(50);
        moveSlider(36);
    }


    public void moveSlider(int userSliderValue){

        if(userSliderValue > getcurrentSliderValue()){
            moveSliderToValue(userSliderValue,Keys.ARROW_RIGHT);
        }else {
            moveSliderToValue(userSliderValue,Keys.ARROW_LEFT);
        }

        Assert.assertEquals(getcurrentSliderValue(),userSliderValue);
    }

    private void moveSliderToValue(int userSliderValue, Keys keys){
        while (userSliderValue != getcurrentSliderValue()){
            getSliderHandle().sendKeys(keys);
        }
    }

    public int getcurrentSliderValue(){
        return Integer.parseInt(getSliderHandle().getText());
    }

    private WebElement getSliderHandle(){
        return driver.findElement(By.cssSelector("#custom-handle"));
    }

}
