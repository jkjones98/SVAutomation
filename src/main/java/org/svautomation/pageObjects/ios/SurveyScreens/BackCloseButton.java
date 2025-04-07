package org.svautomation.pageObjects.ios.SurveyScreens;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.svautomation.utils.IosActions;

import java.util.Map;

import static java.util.Map.entry;

public class BackCloseButton extends IosActions {
    IOSDriver driver;

    public BackCloseButton(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Map<String, Integer> backCloseButton = Map.ofEntries(entry("xPos",41), entry("yPos", 51));
    // x: 41, y: 51

    public void pressBackOrClose() { tapCoords(driver, backCloseButton.get("xPos"), backCloseButton.get("yPos")); }
}
