package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity1 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("^User is on the google home page$")
    public void userisongooglehomepage(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com");
        //driver.manage().window().maximize();
    }

    @Then("^User types Cheese and hits enter$")
    public void userypescheeseandhitsenter(){
        driver.findElement(By.name("q")).sendKeys("cheese", Keys.RETURN);
    }

    @Then("^Show how many search results are shown$")
    public void showHowManySearchResultsWereShown() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }

    @Given("^User is on login page$")
    public void userisonloginpage(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void enterusernamepassword(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button")).click();
    }

    @Then("^Read the page title and confirm$")
    public void readandconfirm(){
        String welcomemessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin", welcomemessage);
    }

   @And("^Close the browser$")
   public void closeTheBrowser() throws Throwable {
      driver.quit();
   }
}
