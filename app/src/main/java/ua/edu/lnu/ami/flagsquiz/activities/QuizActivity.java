package ua.edu.lnu.ami.flagsquiz.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.services.*;

public class QuizActivity extends AppCompatActivity {

    private CountryService countryService;
    private PreferencesService preferencesService;
    private RegionService regionService;
    private StatisticsService statisticsService;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }
}
