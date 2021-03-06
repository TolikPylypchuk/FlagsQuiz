package ua.edu.lnu.ami.flagsquiz.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.MultiSelectListPreference;

import ua.edu.lnu.ami.flagsquiz.models.Preferences;
import ua.edu.lnu.ami.flagsquiz.models.Region;
import ua.edu.lnu.ami.flagsquiz.services.PreferencesService;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;

/**
 * <p>Represents an implementation of a service for accessing flags_quiz_preferences.</p>
 */
public class PreferencesServiceImpl implements PreferencesService {
	
	private Application application;
	private RegionService regionService;
	
	public PreferencesServiceImpl(Application application, RegionService regionService) {
		this.application = Objects.requireNonNull(
			application, "The application must not be null.");
		this.regionService = Objects.requireNonNull(
			regionService, "The region service must not be null.");
	}
	
	@Override
	public Preferences get() {
		SharedPreferences sharedPreferences = application.getSharedPreferences(
				PreferencesService.PREFERENCES_NAME, Context.MODE_PRIVATE);
		Preferences preferences = new Preferences();
		preferences.setNumQuestions(Integer.valueOf(sharedPreferences.getString(NUM_QUESTIONS, "10")));
		preferences.setNumChoices(Integer.valueOf(sharedPreferences.getString(NUM_CHOICES, "3")));

		List<Region> regions = regionService.getAll();
		Set<String> regionSet = new HashSet<>();
		for (int i = 0; i < regions.size(); i++){
			regionSet.add(regions.get(i).getName());
		}

		Object[] regionNames = sharedPreferences.getStringSet(REGIONS, regionSet).toArray();
		
		List<Region> preferredRegions = new ArrayList<>();
		
		for (Region region : regions) {
			for (Object regionName : regionNames) {
				if (regionName.equals(region.getId().toString())) {
					preferredRegions.add(region);
					break;
				}
			}
		}
		
		preferences.setRegions(preferredRegions);
		
		return preferences;
	}
	
	@Override
	public void populateRegions(MultiSelectListPreference preference) {
		List<Region> regions = regionService.getAll();
		
		String[] entries = new String[regions.size()];
		String[] entryValues = new String[regions.size()];
		
		for (int i = 0; i < regions.size(); i++) {
			entries[i] = regions.get(i).getName();
			entryValues[i] = regions.get(i).getId().toString();
		}
		
		preference.setEntries(entries);
		preference.setEntryValues(entryValues);
	}
}
