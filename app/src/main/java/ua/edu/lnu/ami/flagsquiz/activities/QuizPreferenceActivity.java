package ua.edu.lnu.ami.flagsquiz.activities;

import android.app.Application;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.constraint.solver.LinearSystem;
import android.view.View;
import android.widget.Button;

import java.util.Set;

import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.services.PreferencesService;

public class QuizPreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new QuizPreferenceFragment()).commit();
    }



    public static class QuizPreferenceFragment extends PreferenceFragment
    {
        private Button saveButton;
        private Button cancelButton;
        private Button resetStatsButton;

        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            getPreferenceManager().setSharedPreferencesName(PreferencesService.PREFERENCES_NAME);
            addPreferencesFromResource(R.xml.flags_quiz_preferences);

            MultiSelectListPreference regionsPreference = (MultiSelectListPreference)findPreference("regions");
            MainActivity.preferencesService.populateRegions(regionsPreference);

            ListPreference questionsNumberPreference = (ListPreference)findPreference("num_questions");
            ListPreference choicesNumberPreference = (ListPreference)findPreference("num_choices");

            //saveButton = findViewById(R.id.saveButton);
            //cancelButton = findViewById(R.id.cancelButton);
            //resetStatsButton = findViewById(R.id.resetStatsButton);

            saveButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  SharedPreferences.Editor editor =
                                                          MainActivity.sharedPreferences.edit();

                                                  questionsNumberPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                                                      @Override
                                                      public boolean onPreferenceChange(Preference preference, Object o) {
                                                          editor.putInt(MainActivity.preferencesService.NUM_QUESTIONS, (Integer) o);
                                                          editor.commit();

                                                          return true;
                                                      }
                                                  });

                                                  choicesNumberPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                                                      @Override
                                                      public boolean onPreferenceChange(Preference preference, Object o) {
                                                          editor.putInt(MainActivity.preferencesService.NUM_CHOICES, (Integer) o);
                                                          editor.commit();

                                                          return true;
                                                      }
                                                  });

                                                  regionsPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                                                      @Override
                                                      public boolean onPreferenceChange(Preference preference, Object o) {
                                                          editor.putStringSet(MainActivity.preferencesService.REGIONS,
                                                                  (Set<String>) o);
                                                          editor.commit();

                                                          return true;
                                                      }
                                                  });

                                                  MainActivity.preferences =
                                                          MainActivity.preferencesService.get(MainActivity.sharedPreferences);
                                              }
                                          });

            cancelButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                   MainActivity.preferences =
                           MainActivity.preferencesService.get(MainActivity.sharedPreferences);
                }
            });

            /*resetStatsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });*/
        }
    }
}