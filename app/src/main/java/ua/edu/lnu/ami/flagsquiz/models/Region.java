package ua.edu.lnu.ami.flagsquiz.models;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * @author Tolik Pylypchuk
 * <p>Represents a region of the world.</p>
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
