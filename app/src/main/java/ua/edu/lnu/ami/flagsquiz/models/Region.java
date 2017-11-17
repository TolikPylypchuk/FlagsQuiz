package ua.edu.lnu.ami.flagsquiz.models;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.Objects;

/**
 * <p>Represents a region of the world.</p>
 */
public class Region extends SugarRecord {
	
	@Unique
	private String name;
	
	public Region() {
	}
	
	public Region(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Region #" + getId() + ": " + name;
	}
}
