package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class TestActivity2 {
    WebDriver driver;

    @BeforeTest
    public void beforemethod(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void test1(){
        String title = driver.getTitle();
        System.out.println("The page title is: " + title);
        Assert.assertEquals("Target Practice", title);
    }

    @Test
    public void test2(){
        WebElement blackbutton = driver.findElement(By.className("ui black button"));
        Assert.assertTrue(blackbutton.isDisplayed());
        Assert.assertEquals(blackbutton.getText(), "Black" );
    }

    @Test(enabled = false)
    public void test3(){
        String subHeading = driver.findElement(By.className("sub header")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }

    @Test()
    public void test4(){
        throw new SkipException("Skipping test case");
    }


    @AfterTest
    public void aftermethod(){
        driver.quit();
    }
}
