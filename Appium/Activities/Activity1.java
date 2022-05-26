package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        //Here we setup the Desired capabilities like we did in Appium Inspector
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");

        //The below sets the "Allow Overrides" that we set in Appium Server GUI
        caps.setCapability("noReset", true);

        //Get the Current Package and Current activity from Appium Inspector's "Actions tab"
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");

        //Instantiating the Calculator App
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }

    @Test
    public void Activity1(){
        // Using resource-id
        driver.findElementById("digit_5").click();

        // Using Accessibility ID
        driver.findElementByAccessibilityId("multiply").click();

        // Using XPath
        driver.findElementByXPath("//android.widget.Button[@text='9']").click();

        // Perform Calculation
        driver.findElementById("eq").click();

        // Display Result
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println(result);

        // Assertion
        Assert.assertEquals(result, "45");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
