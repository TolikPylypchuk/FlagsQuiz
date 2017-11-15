package ua.edu.lnu.ami.flagsquiz.activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Pair;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.services.CountryService;
import ua.edu.lnu.ami.flagsquiz.services.PreferencesService;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;
import ua.edu.lnu.ami.flagsquiz.services.StatisticsService;

public class QuizActivity extends Activity {

    private CountryService countryService;
    private PreferencesService preferencesService;
    private RegionService regionService;
    private StatisticsService statisticsService;

    private String countryCorrectName;

    private Integer questionNumber = 1;
    private Integer attemptsCounter = 0;

    private Integer questionsAmount;
    private Integer answersAmount;
    private List<String> regions;

    @Inject
    void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @Inject
    void setPreferencesService(PreferencesService preferencesService) {
        this.preferencesService = preferencesService;
    }

    @Inject
    void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }

    @Inject
    void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public String getCountryCorrectName() {
        return countryCorrectName;
    }

    public void setCountryCorrectName(String countryCorrectName) {
        this.countryCorrectName = countryCorrectName;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Integer getAttemptsCounter() {
        return attemptsCounter;
    }

    public void setAttemptsCounter(Integer attemptsCounter) {
        this.attemptsCounter = attemptsCounter;
    }

    public Integer getQuestionsAmount() {
        return questionsAmount;
    }

    public void setQuestionsAmount(Integer questionsAmount) {
        this.questionsAmount = questionsAmount;
    }

    public Integer getAnswersAmount() {
        return answersAmount;
    }

    public void setAnswersAmount(Integer answersAmount) {
        this.answersAmount = answersAmount;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        /*
        Pair<Drawable, String> country = null;
        try {
            country = this.getRandomCountryByRegion("Europe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setCountryCorrectName(country.second);

        ImageView flag = (ImageView) findViewById(R.id.flag);
        flag.setBackground(country.first);

        TextView question = (TextView) findViewById(R.id.question);
        question.setText("Question 1/10");
        */
    }

    private Pair<Drawable, String> getRandomCountryByRegion(String region)
            throws IOException {

        Drawable flag = Drawable.createFromStream(
                getAssets().open("images/uk.png"), null);

        return new Pair<Drawable, String>(flag, "Ukraine");
    }

}
