package org.svautomation.pageObjects.ios.SurveyScreens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.svautomation.utils.IosActions;

public class SurveySectionAnswers extends IosActions {
    IOSDriver driver;
    Boolean isInAccommodationSection = false;

    public SurveySectionAnswers(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectQuestion(String question, Boolean findQuestion) {
        // introduce find next question bool? if true then search if false then let the answer of one question lead into the answer of the next

        // Add change to check if in accommodation section currently and then press back/close and select the section
        if (findQuestion) {
            WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == '" + question + "'`]"));
            waitMethod(1,5, ele, driver);
            ele.click();
        }
    }

    public void answerQuestion(String questionType, String answer, String question) throws InterruptedException {
        String presetListClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell";
        StepperButtons stepperButtons = new StepperButtons(driver);
        // textQuestion
        // presetListQuestion
        // numericQuestion
        // yesNo
        // date-time
        // time
        // photoQuestion
        // stepper
        // address?
        switch(questionType) {
            case "address":

                break;
            case "date-time":
                driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Next\"`]")).click();
                break;
            case "yesNo":
                driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == '" + answer.toUpperCase() + "'`]")).click();
                break;
            case "presetListQuestion":
                driver.findElement(AppiumBy.iOSClassChain(presetListClassChain + "/XCUIElementTypeStaticText[`name == '" + answer + "'`]")).click();
                break;
            case "numericQuestion":
                String checkAnswered = driver.findElement(AppiumBy.iOSClassChain("**XCUIElementTypeTextField")).getText();
                if(!checkAnswered.isEmpty()){
                    driver.findElement(AppiumBy.iOSClassChain("**XCUIElementTypeTextField")).clear();
                }
                driver.findElement(AppiumBy.iOSClassChain("**XCUIElementTypeTextField")).sendKeys(answer + "\n");
                break;
            case "textQuestion":
                driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextView")).sendKeys(answer + "\n");
                break;
            case "photoQuestion":
                driver.findElement(AppiumBy.iOSClassChain("**XCUIElementTypeButton[`" + answer + "`]")).click();
                break;
            case "stepper":
                isInAccommodationSection = true;

                for(int i = 0; i < Integer.parseInt(answer); i++){
                    stepperButtons.pressForAnswer(question);
                }
                break;
            case "garages":
                driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'boxEmpty'`]")).click();
                break;
        }
    }

    public void answerPhotoQuestions(){
        // Create photo tray pageObject?
    }

    public void answerAddressQuestions(){
        // Create list and find element textField/View == Not a quest job
        // Check if list is empty
        // If it is, then press yes if it isn't empty then clear textField/View and then press yes
        // Check that Address section has tick next to it?
    }
}
