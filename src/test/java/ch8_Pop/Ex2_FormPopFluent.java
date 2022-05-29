package ch8_Pop;

import ch3_TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class Ex2_FormPopFluent extends TestBase {
    FormPage formPage;
    File file = new File("src/main/resources/file.txt");

    @BeforeMethod
    public void testSetup(){
        formPage = new FormPage(driver);
        driver.get("https://seleniumui.moderntester.pl/form.php");
    }

    @Test
    public void shouldFillFromWithSuccess(){

        formPage.setFirstName("Jan")
                .setLastName("Kowalski")
                .setEmail("asd@wp.pl")
                .setAge("33")
                .selectRandomGender()
                .setContinent("europe")
                .selectRandomExperience()
                .selectAllProfession()
                .setCommands("browser-commands")
                .uploadFile(file)
                .submitForm();

        Assert.assertEquals(formPage.getValidationMsg(),"Form send with success");
    }
}
