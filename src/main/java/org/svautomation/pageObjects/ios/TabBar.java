package org.svautomation.pageObjects.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TabBar {

    IOSDriver driver;

    public TabBar(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTabBar[`name == 'Tab Bar'`]")
    private WebElement tabBar;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Settings'`]")
    private WebElement settingsBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Itinerary'`]")
    private WebElement itineraryBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Jobs'`]")
    private WebElement jobsBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Diary'`]")
    private WebElement diaryBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Notifications'`]")
    private WebElement notificationsBtn;

    public void chooseScreen(String screenBtn) throws InterruptedException {
        SurveyDefUpdatePopOver surveyDefUpdatePopOver = new SurveyDefUpdatePopOver(driver);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == '" + screenBtn + "'`]")).click();

        surveyDefUpdatePopOver.pressSurveyDefUpdateDownloadBtn();

    }
}
