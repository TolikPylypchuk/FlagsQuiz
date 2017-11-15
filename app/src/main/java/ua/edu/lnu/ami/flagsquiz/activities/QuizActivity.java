package ua.edu.lnu.ami.flagsquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    private Integer questionsAmount = 10;
    private Integer answersAmount = 6;
    private List<String> regions = new ArrayList<>();

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
        regions.add("Europe");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView question = (TextView) findViewById(R.id.question);
        question.setText("Question 1/" + this.questionsAmount);

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
        */
    }

    public void backToMenu(View view) {
        Intent intent = new Intent(QuizActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private Pair<Drawable, String> getRandomCountryByRegion(String region)
            throws IOException {

        InputStream fstream = getApplicationContext().getAssets().open("images/ua.png");
        Drawable flag = Drawable.createFromStream(fstream, null);

        return new Pair<Drawable, String>(flag, "Ukraine");
    }

}
