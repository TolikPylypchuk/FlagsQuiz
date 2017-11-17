package ua.edu.lnu.ami.flagsquiz.services.impl;

import com.orm.SugarRecord;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;
import java.util.Objects;

import ua.edu.lnu.ami.flagsquiz.models.Country;
import ua.edu.lnu.ami.flagsquiz.models.Region;
import ua.edu.lnu.ami.flagsquiz.services.CountryService;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;

/**
 * <p>Represents an implementation of a service for getting countries from the database.</p>
 */
public class CountryServiceImpl implements CountryService {

	private RegionService regionService;

	public CountryServiceImpl(RegionService regionService) {
		this.regionService = regionService;
	}

	@Override
	public Country getById(Long id) {
		Objects.requireNonNull(id, "Id must not be null.");
		return SugarRecord.findById(Country.class, id);
	}
	
	@Override
	public List<Country> getAll() {
		return Select.from(Country.class).list();
	}

	@Override
	public List<Country> getByRegion(String regionName) {

		List<Region> regions = regionService.getAll();
		Region region = null;

		for (Region r : regions) {
			if (r.getName().equals(regionName)) {
				region = r;
				break;
			}
		}

		return Select
				.from(Country.class)
				.where(Condition.prop("region").eq(region != null ? region.getId() : 0))
				.list();
	}
}
