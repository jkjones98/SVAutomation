package org.svautomation.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    IOSDriver driver;

    public LoginPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == 'Username'`]")
    private WebElement usernameField;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == 'Password'`]")
    private WebElement passwordField;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Login'`]")
    private WebElement loginButton;

    public void setUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void pressLogin() {
        loginButton.click();
    }
}
