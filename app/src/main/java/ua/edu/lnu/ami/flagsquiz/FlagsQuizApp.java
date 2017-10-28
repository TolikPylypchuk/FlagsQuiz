package ua.edu.lnu.ami.flagsquiz;

import javax.inject.Inject;

import android.app.Activity;

import com.orm.SugarApp;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import ua.edu.lnu.ami.flagsquiz.di.DaggerFlagsQuizAppComponent;

/**
 * <p>Represents the FlagsQuiz application.</p>
 * @author Tolik Pylypchuk
 */
public class FlagsQuizApp extends SugarApp implements HasActivityInjector {
	
	private DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
	
	@Inject
	void setDispatchingAndroidInjector(DispatchingAndroidInjector<Activity> injector) {
		dispatchingAndroidInjector = injector;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		DaggerFlagsQuizAppComponent.builder().create(this).inject(this);
	}
	
	@Override
	public DispatchingAndroidInjector<Activity> activityInjector() {
		return dispatchingAndroidInjector;
	}
}
