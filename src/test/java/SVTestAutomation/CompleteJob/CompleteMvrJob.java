package SVTestAutomation.CompleteJob;

import SVTestAutomation.TestBase;
import org.json.JSONArray;
import org.svautomation.pageObjects.ios.SurveyScreens.SurveySectionAnswers;
import org.svautomation.pageObjects.ios.SurveyScreens.SurveySections;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.svautomation.pageObjects.ios.SurveyScreens.SurveyListItems;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class CompleteMvrJob extends TestBase {

    @Test(dataProvider = "getMvrData")
    public void CompleteMvr() {
        // Loop over and identify different questions by key-value name
        // Check if section is complete
        // Click on and start new section
        // If all sections complete/no more sections to select then close and start new survey
        SurveyListItems surveyList = new SurveyListItems(driver);


        surveyList.openSelectedSurvey("General Details");
        // Tap on section defined in json
        // Choose surveySection
        // Fill surveySection
        // Assert that section has green tick
        // Choose next surveySection
    }

    @DataProvider(name="getMvrData")
    public Object[][] getMvrData() throws IOException {
        List<HashMap<String,Object>> data = getJsonData("//Users//jj//TestAutomation//SurveyValAutomation//src//test//java//org//svautomation//testData/test.json");
        return new Object[][] {{data.get(0)}};
    }

    @Test(dataProvider = "getMvrData")
    public void checkWhatIsReturned(HashMap<String, Object> input) throws InterruptedException {
        SurveySections surveySections= new SurveySections(driver);
        SurveySectionAnswers surveySectionAnswers = new SurveySectionAnswers(driver);

        JSONObject baseJson = new JSONObject(input);
        JSONArray jsonSection = baseJson.getJSONArray("Section");

        for(int i = 0; i < jsonSection.length(); i++){

            String sectionNames = jsonSection.getJSONObject(i).getString("SectionName");
            // Send sectionName to method in another class to store variable
            System.out.println(sectionNames);
            surveySections.surveySectionSelection(sectionNames);

            JSONArray answerObj2 = jsonSection.getJSONObject(i).getJSONArray("QuestionAnswers");
            for(int j = 0; j < answerObj2.length(); j++) {
                JSONObject questionAnswer = answerObj2.getJSONObject(j);
                //Replace below printlines with method calls and pass in question and question type
                //Make action for wheel picker
                //System.out.println(questionAnswer.getString("question"));

                surveySectionAnswers.selectQuestion(questionAnswer.getString("question"), questionAnswer.getBoolean("findQuestion"));
                surveySectionAnswers.answerQuestion(questionAnswer.getString("questionType"), questionAnswer.getString("answer"), questionAnswer.getString("question"));


            }
        }
    }
}
