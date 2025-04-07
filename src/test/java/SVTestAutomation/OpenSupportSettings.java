package SVTestAutomation;

import org.testng.annotations.Test;
import org.svautomation.pageObjects.ios.SettingsTab.SettingsScreens;
import org.svautomation.pageObjects.ios.SettingsTab.SupportScreen;
import org.svautomation.pageObjects.ios.TabBar;

public class OpenSupportSettings extends TestBase {

    @Test
    public void OpenSupportSettingsPage() throws InterruptedException {

        TabBar tabBar = new TabBar(driver);
        SettingsScreens settingsScreens = new SettingsScreens(driver);

        tabBar.chooseScreen("Settings");
        settingsScreens.openSelectedSettings("Support");
        settingsScreens.enterSupportPasskey("m05yl!");
    }

    @Test
    public void replaceDatabaseFromCloud() throws InterruptedException {
        TabBar tabBar = new TabBar(driver);
        SettingsScreens settingsScreens = new SettingsScreens(driver);
        SupportScreen supportScreen = new SupportScreen(driver);
        supportScreen.pressReplaceDbFromCloud();

        launchSv();

        tabBar.chooseScreen("Settings");
        settingsScreens.openSelectedSettings("Surveyor Details");

    }

}
