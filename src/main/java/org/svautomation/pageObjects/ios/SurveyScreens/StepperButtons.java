package org.svautomation.pageObjects.ios.SurveyScreens;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.svautomation.utils.IosActions;

import java.util.Map;

import static java.util.Map.entry;

public class StepperButtons extends IosActions {
    IOSDriver driver;

    public StepperButtons(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    // Need to be stored as positions
    // Maybe change the name of Maps to reflect their position so this is re-usable for all steppers

    private Map<String, Integer> stepperOneButton = Map.ofEntries(entry("xPos",1100), entry("yPos", 166));

    private Map<String, Integer> stepperTwoButton = Map.ofEntries(entry("xPos",1100), entry("yPos", 228));

    private Map<String, Integer> stepperThreeButton = Map.ofEntries(entry("xPos",1100), entry("yPos", 292));

    private Map<String, Integer> stepperFourButton = Map.ofEntries(entry("xPos",1100), entry("yPos", 356));

    private Map<String, Integer> stepperFiveButton = Map.ofEntries(entry("xPos",1100), entry("yPos", 421));

    private Map<String, Integer> stepperSixButton = Map.ofEntries(entry("xPos",1100), entry("yPos", 483));

    private Map<String, Integer> stepperSevenButton = Map.ofEntries(entry("xPos",1100), entry("yPos", 549));

    private Map<String, Integer> stepperEightButton = Map.ofEntries(entry("xPos",1100), entry("yPos", 613));

    private Map<String, Integer> stepperNineButton = Map.ofEntries(entry("xPos",1100), entry("yPos", 679));

    private Map<String, Integer> completeStepperButton = Map.ofEntries(entry("xPos",1100), entry("yPos", 762));

    public void pressForAnswer(String answer) {
        switch (answer) {
            case "StepperOne":
                tapCoords(driver, stepperOneButton.get("xPos"), stepperOneButton.get("yPos"));
                break;
            case "StepperTwo":
                tapCoords(driver, stepperTwoButton.get("xPos"), stepperTwoButton.get("yPos"));
                break;
            case "StepperThree":
                tapCoords(driver, stepperThreeButton.get("xPos"), stepperThreeButton.get("yPos"));
                break;
            case "StepperFour":
                tapCoords(driver, stepperFourButton.get("xPos"), stepperFourButton.get("yPos"));
                break;
            case "StepperFive":
                tapCoords(driver, stepperFiveButton.get("xPos"), stepperFiveButton.get("yPos"));
                break;
            case "StepperSix":
                tapCoords(driver, stepperSixButton.get("xPos"), stepperSixButton.get("yPos"));
                break;
            case "StepperSeven":
                tapCoords(driver, stepperSevenButton.get("xPos"), stepperSevenButton.get("yPos"));
                break;
            case "StepperEight":
                tapCoords(driver, stepperEightButton.get("xPos"), stepperEightButton.get("yPos"));
                break;
            case "StepperNine":
                tapCoords(driver, stepperNineButton.get("xPos"), stepperNineButton.get("yPos"));
                break;
            case "CompleteStepper":
                tapCoords(driver, completeStepperButton.get("xPos"), completeStepperButton.get("yPos"));
                break;

        }
    }

}
