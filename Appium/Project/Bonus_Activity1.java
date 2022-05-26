package Appium_Project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Bonus_Activity1 {
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

        driver.findElement(MobileBy.id("com.google.android.keep:id/editable_title")).sendKeys("Test Title 2");
        driver.findElement(MobileBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Test Body Description 2");

        Thread.sleep(2000);
        driver.findElement(MobileBy.id("com.google.android.keep:id/menu_switch_to_list_view")).click();
        Thread.sleep(2000);

        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]")).click();
        Thread.sleep(2000);

        driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
        Thread.sleep(2000);

        String reminder = driver.findElement(MobileBy.id("com.google.android.keep:id/reminder_chip_text")).getText();
        System.out.println("The reminder is set for: " + reminder);
        Assert.assertEquals("Today, 6:00 PM", reminder);
    }


//    @AfterClass
//    public void teardown(){
//        driver.quit();
//    }
}
