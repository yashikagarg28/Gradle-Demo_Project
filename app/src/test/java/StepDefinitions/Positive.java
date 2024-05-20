package StepDefinitions;

import Utility.readconfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class Positive {
    protected WebDriver driver;
    readconfig c = new readconfig();

    @Given("User is on login page")
    public void User_is_on_login_page()
    {
        String url = readconfig.getProperty("url");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @When("Enter the username as {string} and password as {string}")
    public void enterUsernameAndPassword(String username, String password) {
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    @And("user click  login button")
    public void userClickLoginButton() {

        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
    }
    @Then("User should able to verify the manager Id")
    public void userShouldAbleToVerifyTheManagerId() {
        driver.findElement(By.xpath("//a[normalize-space()='Manager']")).isDisplayed();
        driver.quit();
    }

    @Then("User should able to see the list of banking services provided")
    public void userShouldAbleToSeeTheListOfBankingServicesProvided() {
        List<WebElement> el= driver.findElements(By.cssSelector(".menusubnav li"));
        Assert.assertEquals(11,el.size());
    }

    @And("User clicks on  logout button")
    public void Userclicksonlogoutbutton() {
        driver.findElement(By.cssSelector("a[href='Logout.php']")).click();
    }

    @Then("User should able to see the alert window")
    public void Usershouldabletoseethealertwindow() {
        String alert = driver.switchTo().alert().getText();
        Assert.assertEquals("You Have Succesfully Logged Out!!", alert);
        driver.quit();
    }

}
