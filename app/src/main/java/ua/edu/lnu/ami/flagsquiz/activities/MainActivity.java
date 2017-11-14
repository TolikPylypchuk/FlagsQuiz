package ua.edu.lnu.ami.flagsquiz.activities;

import android.os.Bundle;

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


//	List<Region> regions = regionService.getAll();
//	List<Country> countries = countryService.getAll();
//	List<Statistics> statistics = statisticsService.getAll();
//  TextView target = findViewById(R.id.textView);
//	target.setText("# of regions: " + regions.size() + "; " +
//		"# of countries: " + countries.size() + "; " +
//		"# of stats entries: " + statistics.size());
	}
}
