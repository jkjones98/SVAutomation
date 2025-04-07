package SVTestAutomation;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.svautomation.utils.IosActions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestBase extends IosActions {

    public static IOSDriver driver;
    public static AppiumDriverLocalService service;
    public static AppiumServiceBuilder builder;
    public FluentWait<IOSDriver> waiting = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(Exception.class);

    @BeforeClass
    public static void configureAppiumForSv() throws URISyntaxException, MalformedURLException {
        // "//usr//local//lib//node_modules//appium//build//lib//main.js"
        builder = new AppiumServiceBuilder().withAppiumJS(new File("//Users//jj//.nvm//versions//node//v22.11.0//lib//node_modules//appium//build//lib//main.js"));
        builder.withIPAddress("127.0.0.1").usingPort(4723);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        // Start server to connect Appium Inspector
        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPad (10th generation)");
        options.setPlatformVersion("18.2");
        driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        launchSv();
    }

    public static void launchSv() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("bundleId", "net.etech.dev.SurveyValuation");
        // Invoke pre-existing app - identifying it using the BundleID above
        driver.executeScript("mobile:launchApp", params);
    }

    public static void tearDown() {
        driver.quit();
        service.stop();
    }




}
