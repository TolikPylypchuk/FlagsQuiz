package ua.edu.lnu.ami.flagsquiz.activities;

import java.util.List;

import javax.inject.Inject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dagger.android.DaggerActivity;

import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.models.Country;
import ua.edu.lnu.ami.flagsquiz.models.Region;
import ua.edu.lnu.ami.flagsquiz.models.Statistics;
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

	Button settingsButton;
	
	@Override
	@SuppressLint("SetTextI18n")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<Region> regions = regionService.getAll();
		List<Country> countries = countryService.getAll();
		List<Statistics> statistics = statisticsService.getAll();
		
		TextView target = findViewById(R.id.target);
		target.setText("# of regions: " + regions.size() + "; " +
			"# of countries: " + countries.size() + "; " +
			"# of stats entries: " + statistics.size());

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
