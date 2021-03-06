
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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.models.Region;
import ua.edu.lnu.ami.flagsquiz.services.PreferencesService;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;
import ua.edu.lnu.ami.flagsquiz.services.StatisticsService;

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
        private RegionService regionService;
        private PreferencesService preferencesService;
        private StatisticsService statisticsService;

        @Inject
        public void setRegionService(RegionService regionService) {
            this.regionService = regionService;
        }

        @Inject
        public void setPreferencesService(PreferencesService preferencesService) {
            this.preferencesService = preferencesService;
        }

        @Inject
        void setStatisticsService(StatisticsService statisticsService) {
            this.statisticsService = statisticsService;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.preferences_activity, container, false);

            MultiSelectListPreference regionsPreference = (MultiSelectListPreference)findPreference("regions");
            preferencesService.populateRegions(regionsPreference);
            
            Button resetStatsButton = view.findViewById(R.id.resetStatsButton);

            resetStatsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    statisticsService.deleteAll();
                    Toast.makeText(getActivity(), "Statistics table is empty.",
                            Toast.LENGTH_LONG).show();
                }
            });

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