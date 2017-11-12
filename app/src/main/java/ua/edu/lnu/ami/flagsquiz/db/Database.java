package ua.edu.lnu.ami.flagsquiz.db;

import com.orm.SugarRecord;

import ua.edu.lnu.ami.flagsquiz.models.Country;
import ua.edu.lnu.ami.flagsquiz.models.Region;

/**
 * <p>Contains methods to initialize the database.</p>
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
        Region asia = new Region("Asia");
        Region europe = new Region("Europe");
        Region northAmerica = new Region("North America");
        Region oceania = new Region("Oceania");
        Region southAmerica = new Region("South America");

        Country[] countries = new Country[]{
                //Africa
                new Country("Algeria", "dz.png", africa),
                new Country("Angola", "ao.png", africa),
                new Country("Benin", "bj.png", africa),
                new Country("Botswana", "bw.png", africa),
                new Country("Burkina Faso", "bf.png", africa),
                new Country("Burundi", "bi.png", africa),
                new Country("Cameroon", "cm.png", africa),
                new Country("Cape Verde", "cv.png", africa),
                new Country("The Central African Republic", "cf.png", africa),
                new Country("Chad", "ro.png", africa),
                new Country("The Comoros", "km.png", africa),
                new Country("Cote d'Ivoire", "ci.png", africa),
                new Country("The Democratic Republic of the Congo", "cd.png", africa),
                new Country("Djibouti", "dj.png", africa),
                new Country("Egypt", "eg.png", africa),
                new Country("Equatorial Guinea", "gq.png", africa),
                new Country("Eritrea", "er.png", africa),
                new Country("Ethiopia", "et.png", africa),
                new Country("Gabon", "ga.png", africa),
                new Country("The Gambia", "gm.png", africa),
                new Country("Ghana", "gh.png", africa),
                new Country("Guinea", "gn.png", africa),
                new Country("Guinea-Bissau", "gw.png", africa),
                new Country("Kenya", "ke.png", africa),
                new Country("Lesotho", "ls.png", africa),
                new Country("Liberia", "lr.png", africa),
                new Country("Libya", "ly.png", africa),
                new Country("Madagascar", "mg.png", africa),
                new Country("Malawi", "mw.png", africa),
                new Country("Mali", "ml.png", africa),
                new Country("Mauritania", "mr.png", africa),
                new Country("Mauritius", "mu.png", africa),
                new Country("Morocco", "ma.png", africa),
                new Country("Mozambique", "mz.png", africa),
                new Country("Namibia", "na.png", africa),
                new Country("Niger", "ne.png", africa),
                new Country("Nigeria", "ng.png", africa),
                new Country("The Republic of the Congo", "cg.png", africa),
                new Country("Rwanda", "rw.png", africa),
                new Country("Sao Tome and Principe", "st.png", africa),
                new Country("Senegal", "sn.png", africa),
                new Country("The Seychelles", "sc.png", africa),
                new Country("Sierra Leone", "sl.png", africa),
                new Country("Somalia", "so.png", africa),
                new Country("South Africa", "za.png", africa),
                new Country("South Sudan", "ss.png", africa),
                new Country("Sudan", "sd.png", africa),
                new Country("Swaziland", "sz.png", africa),
                new Country("Tanzania", "tz.png", africa),
                new Country("Togo", "tg.png", africa),
                new Country("Tunisia", "tn.png", africa),
                new Country("Uganda", "up.png", africa),
                new Country("Western Sahara", "eh.png", africa),
                new Country("Zambia", "zm.png", africa),
                new Country("Zimbabwe", "zw.png", africa),

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
