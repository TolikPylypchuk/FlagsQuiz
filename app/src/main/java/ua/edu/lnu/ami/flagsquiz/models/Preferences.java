package ua.edu.lnu.ami.flagsquiz.models;

import java.util.List;

/**
 * <p>Represents the application preferences.</p>
 */
public class Preferences {

	
	private int numQuestions;
	private int numChoices;
	private List<Region> regions;
	
	public int getNumQuestions() {
		return numQuestions;
	}
	
	public void setNumQuestions(int numQuestions) {
		this.numQuestions = numQuestions;
	}
	
	public int getNumChoices() {
		return numChoices;
	}
	
	public void setNumChoices(int numChoices) {
		this.numChoices = numChoices;
	}
	
	public List<Region> getRegions() {
		return regions;
	}
	
	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}
}
