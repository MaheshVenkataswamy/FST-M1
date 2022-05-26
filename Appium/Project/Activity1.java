package Appium_Project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Activity1 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);

        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");

        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);

    }

    @Test
    public void test() throws InterruptedException {
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();

        //Adding the 1st task
        Thread.sleep(3000);
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        //Adding the 2nd task
        Thread.sleep(2500);
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        Thread.sleep(3000);
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        //Adding the 3rd task
        Thread.sleep(2500);
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        Thread.sleep(3000);
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        //Counting the number of activities added
        Thread.sleep(3000);
        List<MobileElement> numberOfTasks = driver.findElementsById("com.google.android.apps.tasks:id/task_name");
        //List<MobileElement> numberOfTasks = driver.findElementsByXPath("//android.widget.FrameLayout[@content-desc=\"Complete\"]");
        System.out.println("The number of tasks added are: " + numberOfTasks.size());

        Assert.assertEquals(3, numberOfTasks.size());
    }
//
//    @AfterClass
//    public void teardown(){
//        driver.quit();
//    }
}
