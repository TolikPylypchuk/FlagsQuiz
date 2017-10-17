package ua.edu.lnu.ami.flagsquiz.models;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * @author Tolik Pylypchuk
 * <p>Represents a country.</p>
 */
public class Country extends SugarRecord {
	
	@Unique
	private String name;
	
	@Unique
	private String imagePath;
	
	private Region region;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public Region getRegion() {
		return region;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
}
