package homework_SeleniumBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework_DataPickers extends TestBase {

    String pickUserDate = "08/25/2022";
    int pickDayByUser = 25;
    int pickMonthByUser = 7;
    int pickYearByUser = 2022;

    @Test
    public void shouldPickDate() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        driver.findElement(By.cssSelector("#datepicker")).click();


        if (getCurrentYear() == pickYearByUser) {
            pickCorrectMonth();
            pickCorrectDay();
        } else if (getCurrentYear() > pickYearByUser) {
            while (getCurrentYear() != pickYearByUser) {
                getPrevArrowHandler().click();
            }
            pickCorrectMonth();
            pickCorrectDay();
        } else {
            while (getCurrentYear() != pickYearByUser) {
                getNextArrowHandler().click();
            }
            pickCorrectMonth();
            pickCorrectDay();
        }

        System.out.println(getDataPicker());
        Assert.assertEquals(getDataPicker(), pickUserDate);
    }

    public WebElement getNextArrowHandler() {
        return driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']"));
    }

    public WebElement getPrevArrowHandler() {
        return driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-w']"));
    }

    public WebElement getDatePickerYear() {
        return driver.findElement(By.cssSelector(".ui-datepicker-year"));
    }

    public List<WebElement> getDateTableElements() {
        return driver.findElements(By.cssSelector("[data-handler='selectDay']"));
    }

    public int getCurrentYear() {
        return Integer.parseInt(getDatePickerYear().getText());
    }

    public int getMonth() {
        return Integer.parseInt(getDateTableElements().get(7).getAttribute("data-month"));
    }

    public List<WebElement> getDaysOfCurrentMonthElements() {
        return driver.findElements(By.cssSelector("a[class='ui-state-default']"));
    }

    public String getDataPicker() {
        return driver.findElement(By.cssSelector("#datepicker")).getAttribute("value");
    }

    public void pickCorrectMonth() {
        if (getMonth() > pickMonthByUser) {
            while (getMonth() != pickMonthByUser) {
                getPrevArrowHandler().click();
            }
        } else {
            while (getMonth() != pickMonthByUser) {
                getNextArrowHandler().click();
            }
        }
    }

    public void pickCorrectDay() {
        for (WebElement pickedDay : getDaysOfCurrentMonthElements()) {
            if (Integer.parseInt(pickedDay.getText()) == pickDayByUser) {
                pickedDay.click();
            }
        }
    }

}
