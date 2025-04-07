package org.svautomation.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.rmi.Remote;
import java.time.Duration;
import java.util.*;

public abstract class IosActions {
    // Class to include all reusable actions i.e. long press, swiping, scrolling

    public List<HashMap<String, Object>> getJsonData(String jsonFilePath) throws IOException {
        //System.getProperty("user.dir")+"//Users//jj//TestAutomation//SurveyValAutomation//src//test//java//org//svautomation//testData/mvr.json"
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, Object>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, Object>>>() {
                });
        return data;
    }

    public List<HashMap<String, String>> getLoginData(String jsonFilePath) throws IOException {
        //System.getProperty("user.dir")+"//Users//jj//TestAutomation//SurveyValAutomation//src//test//java//org//svautomation//testData/mvr.json"
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;
    }

    public void waitMethod(Integer timeoutMinutes, Integer pollingSeconds, WebElement webElement, IOSDriver driver) {
        FluentWait<IOSDriver> genericWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMinutes(timeoutMinutes))
                .pollingEvery(Duration.ofSeconds(pollingSeconds))
                .ignoring(Exception.class);

        genericWait.until(ExpectedConditions.elementToBeClickable(webElement));

    }

    public void tapCoords(IOSDriver driver, int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence tap = new Sequence(finger, 1);
                tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(50)))
                .addAction((finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())));
        driver.perform(Arrays.asList(tap));
    }

    public void pressBackButton() {

    }

    public void scrollToWebElement(WebElement element, String direction, IOSDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        params.put("element", ((RemoteWebElement)element).getId());

        driver.executeScript("mobile:scroll", params);
    }
}