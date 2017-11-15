package ua.edu.lnu.ami.flagsquiz.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

import ua.edu.lnu.ami.flagsquiz.FlagsQuizApp;
import ua.edu.lnu.ami.flagsquiz.activities.MainActivity;
import ua.edu.lnu.ami.flagsquiz.activities.QuizActivity;
import ua.edu.lnu.ami.flagsquiz.activities.StatisticsActivity;
import ua.edu.lnu.ami.flagsquiz.services.*;
import ua.edu.lnu.ami.flagsquiz.services.impl.*;

/**
 * <p>Represents a module which provides Dagger with necessary instances.</p>
 */
@Module
public abstract class FlagsQuizAppModule {
	
	@Binds
	@Singleton
	public abstract Application application(FlagsQuizApp app);
	
	@ContributesAndroidInjector
	public abstract MainActivity contributeMainActivityInjector();

	@ContributesAndroidInjector
	public abstract QuizActivity contributeQuizActivityInjector();

	@ContributesAndroidInjector
	public abstract StatisticsActivity contributeStatisticsActivityInjector();

	@Provides
	@Singleton
	public static CountryService provideCountryService() {
		return new CountryServiceImpl();
	}
	
	@Provides
	@Singleton
	public static RegionService provideRegionService() {
		return new RegionServiceImpl();
	}
	
	@Provides
	@Singleton
	public static PreferencesService providePreferencesService(
		Application application, RegionService regionService) {
		return new PreferencesServiceImpl(application, regionService);
	}
	
	@Provides
	@Singleton
	public static StatisticsService provideStatisticsService() {
		return new StatisticsServiceImpl();
	}
}
