package ua.edu.lnu.ami.flagsquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ua.edu.lnu.ami.flagsquiz.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void startQuiz(View view) {
		Intent intent = new Intent(MainActivity.this, QuizActivity.class);
		startActivity(intent);
	}

	public void settings(View view) {
		Intent intent = new Intent(MainActivity.this, QuizActivity.class);
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
