package ua.edu.lnu.ami.flagsquiz.services;

import java.util.List;

import ua.edu.lnu.ami.flagsquiz.models.Statistics;

/**
 * <p>Represents a service for CRUD operations on statistics.</p>
 * @author Tolik Pylypchuk
 */
public interface StatisticsService {
	
	Statistics getById(Long id);
	List<Statistics> getAll();
	
	long save(Statistics statistics);
	void delete(Long id);
	void deleteAll();
}
