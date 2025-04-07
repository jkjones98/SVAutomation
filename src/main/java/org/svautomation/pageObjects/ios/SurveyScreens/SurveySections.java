package org.svautomation.pageObjects.ios.SurveyScreens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.svautomation.utils.IosActions;

import java.util.List;

public class SurveySections extends IosActions {
    IOSDriver driver;
    String surveyListItemName;
    WebElement surveyListItemElement;

    public SurveySections(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void surveySectionSelection(String surveySection) {

        String nextSection = "**/XCUIElementTypeStaticText[`name == '" + surveySection + "'`]";

        BackCloseButton backCloseButton = new BackCloseButton(driver);
        List<WebElement> elementList = driver.findElements(AppiumBy.iOSClassChain(nextSection));

        // Check if section is visible, if not then press close and find/select element
        if(elementList.isEmpty()){
            backCloseButton.pressBackOrClose();
            elementList.add(driver.findElement(AppiumBy.iOSClassChain(nextSection)));
        }

        driver.findElement(AppiumBy.iOSClassChain(nextSection)).click();
    }

}
