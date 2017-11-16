package ua.edu.lnu.ami.flagsquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import dagger.android.DaggerActivity;
import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.services.CountryService;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;
import ua.edu.lnu.ami.flagsquiz.services.StatisticsService;

public class MainActivity extends DaggerActivity {
	
	private CountryService countryService;
	private RegionService regionService;
	private StatisticsService statisticsService;

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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void startQuiz(View view) {
		Intent intent = new Intent(MainActivity.this, QuizActivity.class);
		startActivity(intent);
	}

	public void settings(View view) {
		Intent intent = new Intent(MainActivity.this, QuizActivity.class);
		startActivity(intent);
	}

	public void statistics(View view) {
		Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
		startActivity(intent);
	}

	public void about(View view) {
		Intent intent = new Intent(MainActivity.this, AboutActivity.class);
		startActivity(intent);
	}

	public void exit(View view) {
		finish();
		System.exit(0);
	}
}
