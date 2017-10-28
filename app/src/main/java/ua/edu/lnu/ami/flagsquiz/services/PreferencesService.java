package ua.edu.lnu.ami.flagsquiz.services;

import ua.edu.lnu.ami.flagsquiz.models.Preferences;

/**
 * <p>Represents a service for for CRUD operations on preferences.</p>
 * @author Tolik Pylypchuk
 */
public interface PreferencesService {
	
	Preferences get();
	void set(Preferences preferences);
	void delete();
}
