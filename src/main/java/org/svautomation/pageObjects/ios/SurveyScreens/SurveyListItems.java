package org.svautomation.pageObjects.ios.SurveyScreens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SurveyListItems {

    IOSDriver driver;
    String surveyListItemName;
    WebElement surveyListItemElement;

    public SurveyListItems(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Keeping this here for just in case rn, might move the method into IosActions as I don't need the names of all of these surveys anymore
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'General Details'`]")
    private WebElement generalDetails;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'External Elements'`]")
    private WebElement externalElements;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'External Elements'`]")
    private WebElement internalElements;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Services'`]")
    private WebElement services;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Floorplan'`]")
    private WebElement floorplan;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Location Images'`]")
    private WebElement locationImages;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Valuation Summary'`]")
    private WebElement valuationSummary;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Document Approval'`]")
    private WebElement documentApproval;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Assessment Submission'`]")
    private WebElement assessmentSubmission;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Submission Details'`]")
    private WebElement submissionDetails;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Survey Elements'`]")
    private WebElement surveyElements;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'EPC'`]")
    private WebElement epc;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'BTL Questions'`]")
    private WebElement btlQuestions;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Risk Assessment'`]")
    private WebElement riskAssessment;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Photo Gallery'`]")
    private WebElement photoGallery;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Sales Comps Form Data'`]")
    private WebElement salesCompFormData;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Rental Comps Form Data'`]")
    private WebElement rentalCompFormData;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Sales Comparison'`]")
    private WebElement salesComparison;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Rental Comparison'`]")
    private WebElement rentalComparison;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'New Build Qualification'`]")
    private WebElement newBuildQualification;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'New Build Data Capture'`]")
    private WebElement newBuildDataCapture;

    public void openSelectedSurvey(String survey) {
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == '" + survey + "'`]")).click();

    }
}
