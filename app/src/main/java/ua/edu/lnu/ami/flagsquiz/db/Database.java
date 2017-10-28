package ua.edu.lnu.ami.flagsquiz.db;

import com.orm.SugarRecord;

import ua.edu.lnu.ami.flagsquiz.models.Country;
import ua.edu.lnu.ami.flagsquiz.models.Region;

/**
 * <p>Contains methods to initialize the database.</p>
 * @author Tolik Pylypchuk
 */
public class Database {
	
	private Database() { }
	
	public static void initialize() {
		if (SugarRecord.count(Country.class) == 0) {
			seed();
		}
	}
	
	private static void seed() {
		
		Region africa = new Region("Africa");
		Region northAmerica = new Region("North America");
		Region southAmerica = new Region("South America");
		Region asia = new Region("Asia");
		Region europe = new Region("Europe");
		Region oceania = new Region("Oceania");
		
		Country[] countries = new Country[] {
			new Country("United Kingdom", "uk.png", europe),
			new Country("Ukraine", "ukraine.png", europe),
			new Country("USA", "usa.png", northAmerica)
		};
		
		SugarRecord.saveInTx(africa, northAmerica, southAmerica, asia, europe, oceania);
		SugarRecord.saveInTx(countries);
	}
}
