package ua.edu.lnu.ami.flagsquiz.services;

import android.preference.MultiSelectListPreference;

import ua.edu.lnu.ami.flagsquiz.models.Preferences;

/**
 * <p>Represents a service for accessing preferences.</p>
 */
public interface PreferencesService {
	
	String PREFERENCES_NAME = "flags_quiz_preferences";
	
	String NUM_QUESTIONS = "num_questions";
	String NUM_CHOICES = "num_choices";
	String REGIONS = "regions";
	
	Preferences get();
	void populateRegions(MultiSelectListPreference regions);
}
