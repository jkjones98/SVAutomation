package org.svautomation.pageObjects.ios.SurveyScreens;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Overview {

    IOSDriver driver;

    public Overview(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Overview'`]")
    private WebElement overviewButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Surveys'`]")
    private WebElement surveysListButton;

    // Add more buttons eventually?

    public void openOverviewScreen() {
        overviewButton.click();
    }

    public void openSurveyListScreen() {
        surveysListButton.click();
    }
}
