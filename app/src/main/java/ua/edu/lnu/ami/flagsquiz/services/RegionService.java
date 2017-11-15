package ua.edu.lnu.ami.flagsquiz.services;

import java.util.List;

import ua.edu.lnu.ami.flagsquiz.models.Region;

/**
 * <p>Represents a service for getting regions from the database.</p>
 */
public interface RegionService {
	
	Region getById(Long id);
	List<Region> getAll();
}
