package ua.edu.lnu.ami.flagsquiz;

import javax.inject.Inject;

import android.app.Activity;
import android.app.Fragment;

import com.orm.SugarApp;

import dagger.android.ContributesAndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;

import ua.edu.lnu.ami.flagsquiz.activities.QuizActivity;
import ua.edu.lnu.ami.flagsquiz.db.Database;
import ua.edu.lnu.ami.flagsquiz.di.DaggerFlagsQuizAppComponent;

/**
 * <p>Represents the FlagsQuiz application.</p>
 */
public class FlagsQuizApp extends SugarApp implements HasActivityInjector, HasFragmentInjector {
	
	private DispatchingAndroidInjector<Activity> activityInjector;
	private DispatchingAndroidInjector<Fragment> fragmentInjector;
	
	@Inject
	void setActivityInjector(DispatchingAndroidInjector<Activity> activityInjector) {
		this.activityInjector = activityInjector;
	}
	
	@Inject
	void setFragmentInjector(DispatchingAndroidInjector<Fragment> fragmentInjector) {
		this.fragmentInjector = fragmentInjector;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		DaggerFlagsQuizAppComponent.builder().create(this).inject(this);
		Database.initialize();
	}
	
	@Override
	public DispatchingAndroidInjector<Activity> activityInjector() {
		return activityInjector;
	}
	
	@Override
	public DispatchingAndroidInjector<Fragment> fragmentInjector() {
		return fragmentInjector;
	}
}
