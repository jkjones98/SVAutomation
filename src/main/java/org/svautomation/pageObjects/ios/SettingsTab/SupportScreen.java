package org.svautomation.pageObjects.ios.SettingsTab;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.svautomation.pageObjects.ios.AlertButtons;

import java.time.Duration;

public class SupportScreen extends AlertButtons {

    IOSDriver driver;

    FluentWait<IOSDriver> waitingDef = new FluentWait<>(driver)
            .withTimeout(Duration.ofMinutes(2))
            .pollingEvery(Duration.ofSeconds(10))
            .ignoring(Exception.class);

    public SupportScreen(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Upload button elements
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Upload Database'`]")
    private WebElement uploadDatabase;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Upload Photos'`]")
    private WebElement uploadPhotos;


    // Replace Db elements
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Replace Database From Local'`]")
    private WebElement replaceDbFromLocal;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Replace Database From Cloud'`]")
    private WebElement replaceDbFromCloud;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Replace Database'`]")
    private WebElement replaceDbPopup;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Success'`]")
    private WebElement replaceDbSuccess;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`name == 'Allow Restamp'`]")
    private WebElement allowRestamp;


    // Import and Export Db
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Import Database'`]")
    private WebElement importDb;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Export Database'`]")
    private WebElement exportDb;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`name == 'Skip EPC sitenote upload to Assessor Hub'`]")
    private WebElement skipEpcSitenote;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Extend Photo Limit'`]")
    private WebElement extendPhotoLimit;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Enable Embedded Floorplan'`]")
    private WebElement enableEmbeddedFloorplan;

    public void pressReplaceDbFromCloud() {
        replaceDbFromCloud.click();
        waitingDef.until(ExpectedConditions.elementToBeClickable(alertOkButton));
        alertOkButton.click();

        waitingDef.until(ExpectedConditions.elementToBeClickable(alertOkButton));
        alertOkButton.click();

        waitingDef.until(ExpectedConditions.elementToBeClickable(alertOkButton));
        alertOkButton.click();
    }

}

