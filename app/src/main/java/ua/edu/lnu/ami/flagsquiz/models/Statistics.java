package ua.edu.lnu.ami.flagsquiz.models;

import java.util.Date;

import com.orm.SugarRecord;

/**
 * <p>Represents a statistics about a quiz.</p>
 * @author Tolik Pylypchuk
 */
public class Statistics extends SugarRecord {
	
	private Date dateTime;
	private int numQuestions;
	private int numAttempts;
	
	public Statistics() {
	}
	
	public Statistics(Date dateTime, int numQuestions, int numAttempts) {
		this.dateTime = dateTime;
		this.numQuestions = numQuestions;
		this.numAttempts = numAttempts;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public int getNumQuestions() {
		return numQuestions;
	}
	
	public void setNumQuestions(int numQuestions) {
		this.numQuestions = numQuestions;
	}
	
	public int getNumAttempts() {
		return numAttempts;
	}
	
	public void setNumAttempts(int numAttempts) {
		this.numAttempts = numAttempts;
	}
	
	@Override
	public String toString() {
		return "Statistics #" + getId() + ": " + dateTime + "; # of questions: " +
			numQuestions + "; # of attempts: " + numAttempts;
	}
}
