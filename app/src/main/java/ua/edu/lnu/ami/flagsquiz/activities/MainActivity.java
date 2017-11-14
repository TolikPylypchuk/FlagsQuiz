package ua.edu.lnu.ami.flagsquiz.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import javax.inject.Inject;

import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.services.CountryService;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;
import ua.edu.lnu.ami.flagsquiz.services.StatisticsService;

public class MainActivity extends Activity{
	
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
}
