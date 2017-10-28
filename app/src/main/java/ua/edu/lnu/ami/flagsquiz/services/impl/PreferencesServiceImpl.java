package ua.edu.lnu.ami.flagsquiz.services.impl;

import java.util.List;
import java.util.Objects;

import android.app.Application;
import android.preference.MultiSelectListPreference;

import ua.edu.lnu.ami.flagsquiz.models.Preferences;
import ua.edu.lnu.ami.flagsquiz.models.Region;
import ua.edu.lnu.ami.flagsquiz.services.PreferencesService;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;

/**
 * @author Tolik Pylypchuk
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
		return null;
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
