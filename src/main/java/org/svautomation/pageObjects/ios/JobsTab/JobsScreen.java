package org.svautomation.pageObjects.ios.JobsTab;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class JobsScreen {

    IOSDriver driver;

    public JobsScreen(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Jobs currently displayed
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'E2E Test'`]")
    private WebElement mvrJob;

    // Job status filters
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Today'`]")
    private WebElement todayFilter;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'In Progress'`]")
    private WebElement inProgressFilter;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Completed'`]")
    private WebElement completedFilter;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Submitted'`]")
    private WebElement submittedFilter;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Signed Off'`]")
    private WebElement signedOffFilter;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Submitted to Survey Hub'`]")
    private WebElement submittedToSurveyHubFilter;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Submitted Externally'`]")
    private WebElement submittedExternallyFilter;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Manual Sign Off Required'`]")
    private WebElement manualSignOffRequiredFilter;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'External System Updated'`]")
    private WebElement externalSystemUpdatedFilter;

    public void openMvrJob() {
        mvrJob.click();
    }

}
