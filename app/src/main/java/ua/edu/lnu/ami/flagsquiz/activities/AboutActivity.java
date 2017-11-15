package ua.edu.lnu.ami.flagsquiz.activities;

import android.app.Activity;
import android.os.Bundle;

import dagger.android.DaggerActivity;
import ua.edu.lnu.ami.flagsquiz.R;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
}
