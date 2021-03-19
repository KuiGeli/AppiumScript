import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.jupiter.api.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class AppiumScript {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @BeforeEach
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "JAAZGV310230MJE");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.doradogames.conflictnations.worldwar3");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.bytro.sup.MainActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @RepeatedTest(value = 5)
    public void testUntitled() {
        // driver.findElement(By.xpath("//*[@text='Conflict of Nations - World War 3']")).click();
        driver.findElement(By.xpath("//*[@id='func_sg_loginform_button']")).click();
        driver.findElement(By.xpath("//*[@id='func_sg_registerform_button']")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}