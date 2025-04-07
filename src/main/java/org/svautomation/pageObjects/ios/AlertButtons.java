package org.svautomation.pageObjects.ios;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class AlertButtons {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'OK'`]")
    public WebElement alertOkButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Cancel'`]")
    public WebElement alertCancelButton;

}
