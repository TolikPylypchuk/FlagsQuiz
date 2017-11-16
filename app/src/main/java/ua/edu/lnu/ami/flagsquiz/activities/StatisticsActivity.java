package ua.edu.lnu.ami.flagsquiz.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.orm.dsl.Table;

import java.util.List;

import javax.inject.Inject;

import dagger.android.DaggerActivity;
import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.models.Statistics;
import ua.edu.lnu.ami.flagsquiz.services.StatisticsService;

public class StatisticsActivity extends Activity {

    private StatisticsService statisticsService;
    TableLayout table;

    @Inject
    void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        List<Statistics> statisticsList = this.statisticsService.getAll();
        table = findViewById(R.id.statistics);

        for (Statistics stats : statisticsList) {
            TextView date = new TextView(this);
            date.setText(stats.getDateTime().toString());
            TextView questions = new TextView(this);
            questions.setText(stats.getNumQuestions());
            TextView attempts = new TextView(this);
            attempts.setText(stats.getNumAttempts());
            TextView percentage = new TextView(this);
            percentage.setText((int)((double)stats.getNumAttempts() * 100 / stats.getNumQuestions()));

            TableRow row = new TableRow(this);

            row.addView(date);
            row.addView(questions);
            row.addView(attempts);
            row.addView(percentage);

            table.addView(row);
        }
    }
}