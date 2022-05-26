package Activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);

        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");

        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);

    }

    @Test
    public void add(){
        driver.findElementById("digit_5").click();
        driver.findElementById("op_add").click();
        driver.findElementById("digit_9").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println("Add result: " + result);

        Assert.assertEquals(result, "14");
    }

    @Test
    public void subtract(){
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("op_sub").click();
        driver.findElementById("digit_5").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println("Subtract result: " + result);

        Assert.assertEquals(result, "5");
    }

    @Test
    public void multiply(){
        driver.findElementById("digit_5").click();
        driver.findElementById("op_mul").click();
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println("Multiply result: " + result);

        Assert.assertEquals(result, "500");
    }

    @Test
    public void divide(){
        driver.findElementById("digit_5").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("op_div").click();
        driver.findElementById("digit_2").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println("Division result: " + result);
        Assert.assertEquals(result, "25");
    }

        @AfterClass
    public void teardown(){
        driver.quit();
    }

}
