package ua.edu.lnu.ami.flagsquiz.services;

import java.util.List;

import ua.edu.lnu.ami.flagsquiz.models.Country;

/**
 * <p>Represents a service for getting countries from the database.</p>
 */
public interface CountryService {
	
	Country getById(Long id);
	List<Country> getAll();
}
