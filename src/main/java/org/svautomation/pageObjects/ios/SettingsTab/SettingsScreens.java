package org.svautomation.pageObjects.ios.SettingsTab;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingsScreens {

    IOSDriver driver;

    public SettingsScreens(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Internal Device Support'`]")
    private WebElement internalDeviceSupport;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'General'`]")
    private WebElement general;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Surveyor Details'`]")
    private WebElement surveyorDetails;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Download History'`]")
    private WebElement downloadHistory;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'PCDF Settings'`]")
    private WebElement pcdfSettings;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Support'`]")
    private WebElement support;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == 'Password'`]")
    private WebElement supportPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Cancel'`]`]")
    private WebElement supportPasswordCancel;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'OK'`]`]")
    private WebElement supportPasswordOk;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Password Management'`]")
    private WebElement passwordManagement;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Survey Definitions'`]")
    private WebElement surveyDefintions;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Valuation'`]")
    private WebElement valuation;

    public void openSelectedSettings(String selectedSetting) {
        switch(selectedSetting) {
            case "Internal Device Support":
                internalDeviceSupport.click();
                break;
            case "General":
                general.click();
                break;
            case "Surveyor Details":
                surveyorDetails.click();
                break;
            case "Download History":
                downloadHistory.click();
                break;
            case "PCDF Settings":
                pcdfSettings.click();
                break;
            case "Support":
                support.click();
                break;
            case "Password Management":
                passwordManagement.click();
                break;
            case "Survey Definitions":
                surveyDefintions.click();
                break;
            case "Valuation":
                valuation.click();
                break;
            default:
                general.click();
        }


    }

    public void enterSupportPasskey(String password) {
        supportPassword.sendKeys(password);
    }
}
