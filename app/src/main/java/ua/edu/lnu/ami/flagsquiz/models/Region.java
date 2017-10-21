package ua.edu.lnu.ami.flagsquiz.models;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * <p>Represents a region of the world.</p>
 * @author Tolik Pylypchuk
 */
public class Region extends SugarRecord {
	
	@Unique
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}