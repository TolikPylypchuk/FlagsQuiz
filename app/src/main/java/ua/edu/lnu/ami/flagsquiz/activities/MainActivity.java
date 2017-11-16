package ua.edu.lnu.ami.flagsquiz.activities;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import android.app.Application;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dagger.android.DaggerActivity;

import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.models.Country;
import ua.edu.lnu.ami.flagsquiz.models.Preferences;
import ua.edu.lnu.ami.flagsquiz.models.Region;
import ua.edu.lnu.ami.flagsquiz.models.Statistics;
import ua.edu.lnu.ami.flagsquiz.services.CountryService;
import ua.edu.lnu.ami.flagsquiz.services.PreferencesService;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;
import ua.edu.lnu.ami.flagsquiz.services.StatisticsService;

public class MainActivity extends DaggerActivity {

	private Application application;
	private CountryService countryService;
	private RegionService regionService;
	private StatisticsService statisticsService;
    static PreferencesService preferencesService;
	static SharedPreferences sharedPreferences;

	@Inject
	void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@Inject
	void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}
	
	@Inject
	void setStatisticsService(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}

	Button settingsButton;
	
	@Override
	@SuppressLint("SetTextI18n")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.application = Objects.requireNonNull(
				application, "The application must not be null.");

		sharedPreferences = application.getSharedPreferences(
						PreferencesService.PREFERENCES_NAME, Context.MODE_PRIVATE);

		List<Region> regions = regionService.getAll();
		List<Country> countries = countryService.getAll();
		List<Statistics> statistics = statisticsService.getAll();

		settingsButton = findViewById(R.id.settingsButton);
		settingsButton.setOnClickListener( new View.OnClickListener()
		{
			public void onClick (View v){
				Intent intent = new Intent(MainActivity.this, QuizPreferenceActivity.class);
				startActivity(intent);
			}
		});
	}
}
