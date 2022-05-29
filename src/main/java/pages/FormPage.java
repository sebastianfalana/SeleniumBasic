package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#inputFirstName3")
    private WebElement firstName;
    @FindBy (css = "#inputLastName3")
    private WebElement lastName;
    @FindBy (css = "#inputEmail3")
    private WebElement email;
    @FindBy (css = "#inputAge3")
    private WebElement age;

    @FindBy (css = "[name='gridRadiosSex']")
    private List<WebElement> genders;

    @FindBy(css = "#validator-message")
    private WebElement validationMsg;

    @FindBy(css = "#selectContinents")
    private WebElement selectContinents;

    @FindBy (css = "[name='gridRadiosExperience']")
    private List<WebElement> experience;

    @FindBy (css = "[name='gridCheckboxProfession']")
    private List<WebElement> professions;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement selectCommands;

    @FindBy(css = "#chooseFile")
    private WebElement chooseFile;

    @FindBy(css = "[class='btn btn-primary']")
    private WebElement signIn;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement seleniumCommands;


//    public void sellectAllSeleniumCommands(){
//        List<WebElement> commands = new Select(selectCommands).getOptions();
//        for (WebElement command: commands) {
//            seleniumCommands.click();
//        }
//
//    }
    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }
    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }
    public void setEmail(String email){
        this.email.sendKeys(email);
    }
    public void setAge(String age){
        this.age.sendKeys(age);
    }
    public void setContinent(String continent){
        new Select(selectContinents).selectByValue(continent);
    }
    public void selectRandomGender(){
        getRandomElement(genders).click();
    }
    public void selectRandomExperience(){
        getRandomElement(experience).click();
    }

    public void selectAllProfession(){
        for (WebElement profession :
                professions) {
            profession.click();
        }
    }

    public void setCommands(String commands){
        new Select(selectCommands).selectByValue(commands);
    }

    public void selectSignIn(){
        signIn.click();
    }

    public void setFile(File fileToUpload){
//        File fileToUpload = new File("src/main/resources/file.txt");
        chooseFile.sendKeys(fileToUpload.getAbsolutePath());
    }

    public String getValidationMsg(){
        return validationMsg.getText();
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomListIndex = rnd.nextInt(elements.size());
        return elements.get(randomListIndex);
    }


}
