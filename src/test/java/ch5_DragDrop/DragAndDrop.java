package ch5_DragDrop;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class DragAndDrop extends TestBase {

    @Test
    public void shouldDragAndDrop(){
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        WebElement drag = driver.findElement(By.cssSelector("#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .perform();

        String dropText = driver.findElement(By.cssSelector("#droppable")).getText();
        Assert.assertEquals(dropText,"Dropped!");
    }

    @Test
    public void shoulDragAndDropTwo() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        WebElement drag = driver.findElement(By.cssSelector("#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("#droppable"));

        Actions actions= new Actions(driver);
        actions.dragAndDrop(drag,drop);

        String dropText = driver.findElement(By.cssSelector("#droppable")).getText();
        Assert.assertEquals(dropText,"Dropped!");
    }

    @Test
    public void shouldDragAndDropThree(){
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        WebElement drag = driver.findElement(By.cssSelector("#draggable"));

        Actions actions = new Actions((driver));
        actions.clickAndHold(drag)
                .moveByOffset(200,50)
                .release()
                .perform();

        String dropText = driver.findElement(By.cssSelector("#droppable")).getText();
        Assert.assertEquals(dropText,"Dropped!");

    }

    @Test
    public void shouldDragAndDropFour(){
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        WebElement drag = driver.findElement(By.cssSelector("#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("#droppable"));
        int dragX = driver.findElement(By.cssSelector("#draggable")).getLocation().x;
        int dragY = driver.findElement(By.cssSelector("#draggable")).getLocation().y;
        int dropX = driver.findElement(By.cssSelector("#droppable")).getLocation().x;
        int dropY = driver.findElement(By.cssSelector("#droppable")).getLocation().y;

        int dropWidth = drop.getSize().width;
        int dropHeight = drop.getSize().height;

        int offsetX = dropX - dragX +dropWidth/4;
        int offsetY = dropY - dragY + dropHeight/4;

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag)
                .moveByOffset(offsetX,offsetY)
                .release()
                .perform();

        String dropText = driver.findElement(By.cssSelector("#droppable")).getText();
        Assert.assertEquals(dropText,"Dropped!");
    }
}
