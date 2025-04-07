package SVTestAutomation;

import org.testng.annotations.Test;
import org.svautomation.pageObjects.ios.LoginPage;
import org.svautomation.pageObjects.ios.SettingsTab.SettingsScreens;
import org.svautomation.pageObjects.ios.SurveyDefUpdatePopOver;
import org.svautomation.pageObjects.ios.TabBar;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SVLoginLogout extends TestBase{

    // Group with logout test and launch page tests, add new methods for these
    @Test(dataProvider = "getData")
    public void SVLoginLogoutTest(HashMap<String, String> input) throws InterruptedException  {

        LoginPage loginPage = new LoginPage(driver);
        SurveyDefUpdatePopOver surveyDefUpdatePopOver = new SurveyDefUpdatePopOver(driver);
        TabBar tabBar = new TabBar(driver);
        SettingsScreens settingsScreens = new SettingsScreens(driver);

        //configureAppiumForSv()

        loginPage.setUsername(input.get("Username"));
        loginPage.setPassword(input.get("Password"));
        loginPage.pressLogin();

        // Got to be a way to do this implicitly, but explicit it is for now
        //Thread.sleep(3000);
        tabBar.chooseScreen("Jobs");
        Thread.sleep(3000);
        tabBar.chooseScreen("Settings");

        //surveyDefUpdatePopOver.pressSurveyDefUpdateDownloadBtn();

        tabBar.chooseScreen("Settings");
        settingsScreens.openSelectedSettings("Surveyor Details");


    }

    @DataProvider(name="getData")
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getLoginData("//Users//jj//TestAutomation//SurveyValAutomation//src//test//java//org//svautomation//testData/login.json");
        return new Object[][] { {data.getFirst()} };
    }
}
