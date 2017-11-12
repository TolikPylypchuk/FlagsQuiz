package ua.edu.lnu.ami.flagsquiz.db;

import com.orm.SugarRecord;

import ua.edu.lnu.ami.flagsquiz.models.Country;
import ua.edu.lnu.ami.flagsquiz.models.Region;

/**
 * <p>Contains methods to initialize the database.</p>
 *
 * @author Tolik Pylypchuk
 */
public class Database {

    private Database() {
    }

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

        Country[] countries = new Country[]{
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

                // Asia
                new Country("Afghanistan", "af.png", asia),
                new Country("Armenia", "am.png", asia),
                new Country("Azerbaijan", "az.png", asia),
                new Country("Bahrain", "bh.png", asia),
                new Country("Bangladesh", "bd.png", asia),
                new Country("Bhutan", "bt.png", asia),
                new Country("Brunei", "bn.png", asia),
                new Country("Cambodia", "kh.png", asia),
                new Country("Cyprus", "cy.png", asia),
                new Country("East Timor", "tl.png", asia),
                new Country("Egypt", "eg.png", asia),
                new Country("Georgia", "ge.png", asia),
                new Country("India", "in.png", asia),
                new Country("Indonesia", "id.png", asia),
                new Country("Iran", "ir.png", asia),
                new Country("Iraq", "iq.png", asia),
                new Country("Israel", "il.png", asia),
                new Country("Japan", "jp.png", asia),
                new Country("Jordan", "jo.png", asia),
                new Country("Kazakhstan", "kz.png", asia),
                new Country("Kuwait", "kw.png", asia),
                new Country("Kyrgyzstan", "kg.png", asia),
                new Country("Laos", "la.png", asia),
                new Country("Lebanon", "lb.png", asia),
                new Country("Malaysia", "my.png", asia),
                new Country("Maldives", "mv.png", asia),
                new Country("Mongolia", "mn.png", asia),
                new Country("Myanmar", "mm.png", asia),
                new Country("Nepal", "np.png", asia),
                new Country("North Korea", "kp.png", asia),
                new Country("Oman", "om.png", asia),
                new Country("Pakistan", "pk.png", asia),
                new Country("The People's Republic of China", "cn.png", asia),
                new Country("The Philippines", "ph.png", asia),
                new Country("Qatar", "qa.png", asia),
                new Country("The Republic of China", "tw.png", asia),
                new Country("Russia", "ru.png", asia),
                new Country("Saudi Arabia", "sa.png", asia),
                new Country("Singapore", "sg.png", asia),
                new Country("South Korea", "kr.png", asia),
                new Country("Sri Lanka", "lk.png", asia),
                new Country("Syria", "sy.png", asia),
                new Country("Tajikistan", "tj.png", asia),
                new Country("Thailand", "th.png", asia),
                new Country("Turkey", "tr.png", asia),
                new Country("Turkmenistan", "tm.png", asia),
                new Country("The United Arab Emirates", "ae.png", asia),
                new Country("Uzbekistan", "uz.png", asia),
                new Country("Vietnam", "vn.png", asia),
                new Country("Yemen", "ye.png", asia),

                new Country("USA", "usa.png", northAmerica)
        };

        SugarRecord.saveInTx(africa, northAmerica, southAmerica, asia, europe, oceania);
        SugarRecord.saveInTx(countries);
    }
}
