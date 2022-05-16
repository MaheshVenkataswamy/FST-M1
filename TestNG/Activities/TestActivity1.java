package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestActivity1 {
    WebDriver driver;

    @BeforeMethod
    public void beforemethod(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        }

    @Test
    public void testmethod(){

        String title = driver.getTitle();
        System.out.println("The page title is:" + title);
        Assert.assertEquals("Training Support", title);

        driver.findElement(By.xpath("//*[@id=\"about-link\"]")).click();
        String newtitle = driver.getTitle();
        System.out.println("The new page title is:" + newtitle);
        Assert.assertEquals("About Training Support", newtitle);
    }

    @AfterMethod
    public void aftermethod(){
        driver.quit();
    }





}
