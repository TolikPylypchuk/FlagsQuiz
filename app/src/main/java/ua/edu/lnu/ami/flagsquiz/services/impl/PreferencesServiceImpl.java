package ua.edu.lnu.ami.flagsquiz.services.impl;

import java.util.Objects;

import android.app.Application;

import ua.edu.lnu.ami.flagsquiz.models.Preferences;
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
	public void set(Preferences preferences) {
	
	}
	
	@Override
	public void delete() {
	
	}
}
