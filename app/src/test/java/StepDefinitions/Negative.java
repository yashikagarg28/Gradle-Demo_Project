package StepDefinitions;
import Utility.readconfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

public class Negative {

    protected WebDriver driver;
    readconfig c = new readconfig();

    @Given("User clicked login page")
    public void User_clicked_login_page()
    {
        String url = readconfig.getProperty("url");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @When("Enter  username as {string} and password as {string}")
    public void enterUsernameAndPassword(String username, String password) {
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    @And("user click on the login button")
    public void userClickOnLoginButton() {

        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
    }

    @Then("Edit customer with wrong customer id")
    public void Editcustomerwithwrongcustomerid() {
        driver.findElement(By.xpath("//a[normalize-space()='Edit Customer']")).click();
        driver.findElement(By.cssSelector("input[name='cusid']")).sendKeys("88890");
        driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Perform actions on the alert
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        // Accept the alert (click OK)
        alert.accept();
        driver.manage().deleteAllCookies();

    }
    @And("User click on the edit option")
    public void userClickOnTheEditOption() throws InterruptedException {
        driver.findElement(By.cssSelector(".menusubnav>li:nth-of-type(6)>a")).click();

    }

    @And("User enters character values in the account number text box")
    public void userEntersCharacterValuesInTheAccountNumberTextBox() {
        driver.findElement(By.cssSelector("[name='accountno']")).sendKeys("abc");
    }
    @Then("User should able to see the error message to update correct values")
    public void userShouldAbleToSeeTheErrorMessageToUpdateCorrectValues() {
        Assert.assertEquals("Characters are not allowed",driver.findElement(By.xpath("//label[@id='message2']")).getText());
        driver.manage().deleteAllCookies();
        driver.quit();


    }
    @And("user clicks on delete button")
    public void userclicksondeletebutton()
    {

        driver.findElement(By.cssSelector(".menusubnav>li:nth-of-type(6)>a")).click();

    }
    @And("clicks submit button")
    public void cickssubmitbutton()
    {
        driver.findElement(By.cssSelector("[value='Submit']")).click();
        System.out.println("Hello");

    }
    @And("Gets a prompt message")
    public void Getsapromptmessage() {
        String msg = driver.switchTo().alert().getText();
        Assert.assertEquals("Please fill all fields", msg);
        driver.switchTo().alert().accept();
        driver.manage().deleteAllCookies();
        driver.quit();

    }
    }


