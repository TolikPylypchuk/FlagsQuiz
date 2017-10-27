package ua.edu.lnu.ami.flagsquiz.services.impl;

import java.util.List;
import java.util.Objects;

import com.orm.SugarRecord;
import com.orm.query.Select;

import ua.edu.lnu.ami.flagsquiz.models.Statistics;
import ua.edu.lnu.ami.flagsquiz.services.StatisticsService;

/**
 * <p>Represents an implementation of a service for CRUD operations on statistics.</p>
 * @author Tolik Pylypchuk
 */
public class StatisticsServiceImpl implements StatisticsService {
	
	@Override
	public Statistics getById(Long id) {
		Objects.requireNonNull(id, "Id must not be null.");
		return SugarRecord.findById(Statistics.class, id);
	}
	
	@Override
	public List<Statistics> getAll() {
		return Select.from(Statistics.class).list();
	}
	
	@Override
	public long save(Statistics statistics) {
		Objects.requireNonNull(statistics, "The statistics must not be null");
		Objects.requireNonNull(
			statistics.getDateTime(), "The statistics' date and time must not be null");
		
		return SugarRecord.save(statistics);
	}
	
	@Override
	public void delete(Long id) {
		id = Objects.requireNonNull(id, "Id must not be null.");
		SugarRecord.deleteAll(Statistics.class, "id = ?", id.toString());
	}
	
	@Override
	public void deleteAll() {
		SugarRecord.deleteAll(Statistics.class);
	}
}
