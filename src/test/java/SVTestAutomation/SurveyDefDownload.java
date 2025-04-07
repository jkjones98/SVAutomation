package SVTestAutomation;

import org.testng.annotations.Test;
import org.svautomation.pageObjects.ios.SurveyDefUpdatePopOver;

public class SurveyDefDownload extends TestBase {


    @Test
    public void DownloadSurveyDefsTest() throws InterruptedException {
        SurveyDefUpdatePopOver surveyDefUpdatePopOver = new SurveyDefUpdatePopOver(driver);

        surveyDefUpdatePopOver.pressSurveyDefUpdateDownloadBtn();
    }
}
