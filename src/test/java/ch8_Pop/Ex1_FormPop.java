package ch8_Pop;

import ch3_TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class Ex1_FormPop extends TestBase {

    @Test
    public void shouldFillFromWithSuccess(){
        driver.get("https://seleniumui.moderntester.pl/form.php");
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Jan");
        formPage.setLastName("Kowalski");
        formPage.setEmail("asd@wp.pl");
        formPage.setAge("33");
        formPage.selectRandomGender();
        formPage.setContinent("europe");
        formPage.selectRandomExperience();
        formPage.selectAllProfession();
        formPage.setCommands("browser-commands");
        formPage.setFile(new File("src/main/resources/file.txt"));
        formPage.selectSignIn();

        Assert.assertEquals(formPage.getValidationMsg(),"Form send with success");
    }
}
