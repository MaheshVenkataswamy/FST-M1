package Appium_Project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);

        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("appPackage", "com.android.chrome");

        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);

        driver.get("https://www.training-support.net/selenium");

        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void test(){
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        //wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[15]/android.view.View")));

        MobileElement toDoList = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[15]/android.view.View"));

        //driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollIntoView(text(\"To-Do List \uF0AE Elements get added at run time\"))")).click();


        //driver.findElementByXPath("//android.view.View[@text='To-Do List \uF0AE Elements get added at run time']").click();


    }


//    @AfterClass
//    public void teardown(){
//        driver.quit();
//    }
}
