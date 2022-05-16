package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestActivity3 {
    WebDriver driver;
    @BeforeTest
    public void beforemethod(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void test1(){
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginbutton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button"));

        username.sendKeys("admin");
        password.sendKeys("password");
        loginbutton.click();

        String loginmsg = driver.findElement(By.id("action-confirmation")).getText();

        Assert.assertEquals("Welcome Back, admin", loginmsg);
    }

    @AfterTest
    public void aftermethod(){
        driver.quit();
    }
}
