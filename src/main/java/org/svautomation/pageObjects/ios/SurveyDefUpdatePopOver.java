package org.svautomation.pageObjects.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.svautomation.utils.IosActions;

import java.time.Duration;

public class SurveyDefUpdatePopOver extends IosActions {

    IOSDriver driver;

    public SurveyDefUpdatePopOver(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }



    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypePopover")
    private WebElement surveyDefUpdatePopOver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Survey Definition Updates'`]")
    private WebElement surveyDefUpdateText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypePopover/XCUIElementTypeOther")
    private WebElement surveyDefUpdateDownloading;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Download'`]")
    private WebElement surveyDefUpdateDownloadBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Download later'`]")
    private WebElement surveyDefUpdateDownloadLaterBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Done'`]")
    private WebElement surveyDefUpdateDownloadDone;

    public void pressSurveyDefUpdateDownloadBtn() throws InterruptedException {

            if(surveyDefUpdateText.isDisplayed()){
                surveyDefUpdateDownloadBtn.click();
                waitMethod(6,20,surveyDefUpdateDownloadDone, driver);

                surveyDefUpdateDownloadDone.click();
            }
            //waitingDef.until(ExpectedConditions.elementToBeClickable(surveyDefUpdateDownloadDone));
    }
}
