package ua.edu.lnu.ami.flagsquiz.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import dagger.android.DaggerActivity;
import ua.edu.lnu.ami.flagsquiz.R;

public class StatisticsActivity extends DaggerActivity {

    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
    }
}
