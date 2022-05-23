package homework_SeleniumBasic;

import ch3_TestBase.TestBase;
import org.testng.Assert;

public class Homework_Harder_Beta_Main extends TestBase {

    public void shouldTextAppearedBeta() {

        int len = 10;
        Selectors selectors = new Selectors();

        driver.get("http://146.59.32.4/index.php");
        selectors.signIn.click();
        selectors.createOne.click();
        selectors.socialTitle.click();
        selectors.firstName.sendKeys("Maniek");
        selectors.lastName.sendKeys("Walczewski");
        selectors.email.sendKeys(new RandomString().generateString(len)+"@yopmail.com");
        selectors.password.sendKeys("blabla");
        selectors.birthday.sendKeys("05/2/1989");
        selectors.customer_privacy.click();
        selectors.privatePolicy.click();
        selectors.saveButton.click();

        String userNameOnThePage = selectors.userName.getText();
        Assert.assertEquals(userNameOnThePage,"Maniek Walczewski");


    }
}
