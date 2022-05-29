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
    public FormPage setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
        return this;
    }
    public FormPage setLastName(String lastName){
        this.lastName.sendKeys(lastName);
        return this;
    }
    public FormPage setEmail(String email){
        this.email.sendKeys(email);
        return this;
    }
    public FormPage setAge(String age){
        this.age.sendKeys(age);
        return this;
    }
    public FormPage setContinent(String continent){
        new Select(selectContinents).selectByValue(continent);
        return this;
    }
    public FormPage selectRandomGender(){
        getRandomElement(genders).click();
        return this;
    }
    public FormPage selectRandomExperience(){
        getRandomElement(experience).click();
        return this;
    }

    public FormPage selectAllProfession(){
        for (WebElement profession :
                professions) {
            profession.click();
        }
        return this;
    }

    public FormPage setCommands(String commands){
        new Select(selectCommands).selectByValue(commands);
        return this;
    }

    public FormPage submitForm(){
        signIn.click();
        return this;
    }

    public FormPage uploadFile(File fileToUpload){
//        File fileToUpload = new File("src/main/resources/file.txt");
        chooseFile.sendKeys(fileToUpload.getAbsolutePath());
        return this;
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
