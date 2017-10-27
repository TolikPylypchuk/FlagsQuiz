package ua.edu.lnu.ami.flagsquiz.activities;

import java.util.List;

import javax.inject.Inject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import dagger.android.DaggerActivity;

import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.models.Country;
import ua.edu.lnu.ami.flagsquiz.models.Region;
import ua.edu.lnu.ami.flagsquiz.services.CountryService;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;

public class MainActivity extends DaggerActivity {
	
	private CountryService countryService;
	private RegionService regionService;
	
	@Inject
	void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@Inject
	void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}
	
	@Override
	@SuppressLint("SetTextI18n")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<Region> regions = regionService.getAll();
		List<Country> countries = countryService.getAll();
		
		TextView target = findViewById(R.id.target);
		target.setText("# of regions: " + regions.size() + "; " +
			"# of countries: " + countries.size());
	}
}
