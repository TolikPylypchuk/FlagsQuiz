package ua.edu.lnu.ami.flagsquiz;

import javax.inject.Inject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import dagger.android.DaggerActivity;
import ua.edu.lnu.ami.flagsquiz.models.Region;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;

public class MainActivity extends DaggerActivity {
	
	private RegionService regionService;
	
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
		
		TextView target = findViewById(R.id.target);
		target.setText("The amount of regions is: " + regions.size());
	}
}
