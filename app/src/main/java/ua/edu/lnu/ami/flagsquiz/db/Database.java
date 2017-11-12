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
			// Europe
			new Country("Albania", "al.png", europe),
			new Country("Andora", "ad.png", europe),
			new Country("Austria", "at.png", europe),
			new Country("Belarus", "by.png", europe),
			new Country("Belgium", "be.png", europe),
			new Country("Bosnia an Herzogovina", "ba.png", europe),
			new Country("Bulgaria", "bg.png", europe),
			new Country("Chroatia", "hr.png", europe),
			new Country("The Czech Republic", "cz.png", europe),
			new Country("Denmark", "dk.png", europe),
			new Country("Estonia", "ee.png", europe),
			new Country("Finland", "fi.png", europe),
			new Country("France", "fr.png", europe),
			new Country("Germany", "de.png", europe),
			new Country("Greece", "gr.png", europe),
			new Country("Hungary", "hu.png", europe),
			new Country("Iceland", "is.png", europe),
			new Country("Ireland", "ie.png", europe),
			new Country("Italy", "it.png", europe),
			new Country("Kosovo", "ks.png", europe),
			new Country("Latvia", "lv.png", europe),
			new Country("Liechtenstein", "li.png", europe),
			new Country("Lithuania", "lt.png", europe),
			new Country("Luxembourg", "lu.png", europe),
			new Country("Macedonia", "mk.png", europe),
			new Country("Malta", "mt.png", europe),
			new Country("Moldova", "md.png", europe),
			new Country("Monaco", "mc.png", europe),
			new Country("Montenegro", "me.png", europe),
			new Country("The Netherlands", "nl.png", europe),
			new Country("Norway", "no.png", europe),
			new Country("Poland", "pl.png", europe),
			new Country("Portugal", "pt.png", europe),
            new Country("Romania", "ro.png", europe),
            new Country("Russia", "ru.png", europe),
            new Country("San Marino", "sm.png", europe),
            new Country("Serbia", "rs.png", europe),
            new Country("Slovakia", "sk.png", europe),
            new Country("Slovenia", "si.png", europe),
            new Country("Spain", "es.png", europe),
            new Country("Sweden", "se.png", europe),
            new Country("Swietzerland", "ch.png", europe),
            new Country("Turkey", "tr.png", europe),
            new Country("Ukraine", "ua.png", europe),
            new Country("The United Kingdom", "gb.png", europe),
            new Country("Vatican", "va.png", europe),
            
			new Country("USA", "usa.png", northAmerica)
		};
		
		SugarRecord.saveInTx(africa, northAmerica, southAmerica, asia, europe, oceania);
		SugarRecord.saveInTx(countries);
	}
}
