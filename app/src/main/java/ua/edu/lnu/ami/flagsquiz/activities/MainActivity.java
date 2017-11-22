package ua.edu.lnu.ami.flagsquiz.activities;
	
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.services.PreferencesService;

public class MainActivity extends Activity {
	
	private Application application;
	
	static PreferencesService preferencesService;
	
	@Inject
	void setApplication(Application application){
		this.application = application;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		AndroidInjection.inject(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.application = Objects.requireNonNull(
			application, "The application must not be null.");
		
	}

	public void startQuiz(View view) {
		Intent intent = new Intent(MainActivity.this, QuizActivity.class);
		startActivity(intent);
	}

	public void settings(View view) {
		Intent intent = new Intent(MainActivity.this, QuizPreferenceActivity.class);
		startActivity(intent);
	}

	public void statistics(View view) {
		Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
		startActivity(intent);
	}

	public void about(View view) {
		Intent intent = new Intent(MainActivity.this, AboutActivity.class);
		startActivity(intent);
	}

	public void exit(View view) {
		finish();
		System.exit(0);
	}
}
