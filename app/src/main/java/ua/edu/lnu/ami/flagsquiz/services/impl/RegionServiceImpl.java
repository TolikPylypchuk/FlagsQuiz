package ua.edu.lnu.ami.flagsquiz.services.impl;

import java.util.List;
import java.util.Objects;

import com.orm.SugarRecord;
import com.orm.query.Select;

import ua.edu.lnu.ami.flagsquiz.models.Region;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;

/**
 * <p>Represents an implementation of a service for getting regions from the database.</p>
 * @author Tolik Pylypchuk
 */
public class RegionServiceImpl implements RegionService {
	
	@Override
	public Region getById(Long id) {
		id = Objects.requireNonNull(id, "Id must not be null.");
		return SugarRecord.findById(Region.class, id);
	}
	
	@Override
	public List<Region> getAll() {
		return Select.from(Region.class).list();
	}
}
