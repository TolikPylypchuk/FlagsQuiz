
package ua.edu.lnu.ami.flagsquiz.activities;

import android.app.Application;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.constraint.solver.LinearSystem;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.models.Region;
import ua.edu.lnu.ami.flagsquiz.services.PreferencesService;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;

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
        RegionService regionService;
        PreferencesService preferencesService;

        @Inject
        public void setRegionService(RegionService regionService) {
            this.regionService = regionService;
        }

        @Inject
        public void setPreferencesService(PreferencesService preferencesService) {
            this.preferencesService = preferencesService;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.preferences_activity, container, false);

            MultiSelectListPreference regionsPreference = (MultiSelectListPreference)findPreference("regions");
            preferencesService.populateRegions(regionsPreference);

            ListPreference questionsNumberPreference = (ListPreference)findPreference("num_questions");
            ListPreference choicesNumberPreference = (ListPreference)findPreference("num_choices");
            Button saveButton = view.findViewById(R.id.saveButton);
            Button cancelButton = view.findViewById(R.id.cancelButton);
            Button resetStatsButton = view.findViewById(R.id.resetStatsButton);

            SharedPreferences.Editor editor =
                    MainActivity.sharedPreferences.edit();

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    questionsNumberPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                        @Override
                        public boolean onPreferenceChange(Preference preference, Object o) {
                            editor.putInt(PreferencesService.NUM_QUESTIONS, (Integer) o);
                            editor.commit();

                            return true;
                        }
                    });

                    choicesNumberPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                        @Override
                        public boolean onPreferenceChange(Preference preference, Object o) {
                            editor.putInt(PreferencesService.NUM_CHOICES, (Integer) o);
                            editor.commit();

                            return true;
                        }
                    });

                    regionsPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                        @Override
                        public boolean onPreferenceChange(Preference preference, Object o) {
                            editor.putStringSet(PreferencesService.REGIONS,
                                    (Set<String>) o);
                            editor.commit();

                            return true;
                        }
                    });

                    Intent i = new Intent(getActivity(), MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }

            });

            cancelButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {

                    editor.putInt(PreferencesService.NUM_QUESTIONS, 10);
                    editor.putInt(PreferencesService.NUM_CHOICES, 3);
                    List<Region> regions = regionService.getAll();
                    Set<String> regionSet = new HashSet<String>();

                    for (int i = 0; i < regions.size(); i++){
                        regionSet.add(regions.get(i).getName());
                    }
                    editor.putStringSet(PreferencesService.REGIONS, regionSet);

                    editor.commit();

                    Intent i = new Intent(getActivity(), MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            });

            /*resetStatsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });*/

            return view;
        }

        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            AndroidInjection.inject(this);

            super.onCreate(savedInstanceState);

            getPreferenceManager().setSharedPreferencesName(PreferencesService.PREFERENCES_NAME);
            addPreferencesFromResource(R.xml.flags_quiz_preferences);
        }
    }
}