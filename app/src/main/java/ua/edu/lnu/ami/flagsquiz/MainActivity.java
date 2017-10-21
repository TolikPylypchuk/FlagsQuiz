package ua.edu.lnu.ami.flagsquiz;

import javax.inject.Inject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import dagger.android.DaggerActivity;

public class MainActivity extends DaggerActivity {
	
	private String injectedString;
	
	@Inject
	void setInjectedString(String injectedString) {
		this.injectedString = injectedString;
	}
	
	@Override
	@SuppressLint("SetTextI18n")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView target = findViewById(R.id.target);
		target.setText("The injected string is: " + injectedString);
	}
}
