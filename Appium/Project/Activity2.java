package Appium_Project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);

        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("appPackage", "com.google.android.keep");

        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void test() throws InterruptedException {
        driver.findElement(MobileBy.id("com.google.android.keep:id/new_note_button")).click();
        Thread.sleep(2500);

        driver.findElement(MobileBy.id("com.google.android.keep:id/editable_title")).sendKeys("Test Title");
        driver.findElement(MobileBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Test Body Description");

        Thread.sleep(2000);
        driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
        Thread.sleep(2000);

        String newNote = driver.findElement(MobileBy.id("com.google.android.keep:id/index_note_title")).getText();

        Assert.assertEquals("Test Title", newNote);
    }


//    @AfterClass
//    public void teardown(){
//        driver.quit();
//    }
}
