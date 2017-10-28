package ua.edu.lnu.ami.flagsquiz.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

import ua.edu.lnu.ami.flagsquiz.activities.MainActivity;
import ua.edu.lnu.ami.flagsquiz.services.*;
import ua.edu.lnu.ami.flagsquiz.services.impl.*;

/**
 * <p>Represents a module which provides Dagger with necessary instances.</p>
 * @author Tolik Pylypchuk
 */
@Module
public abstract class FlagsQuizAppModule {
	
	@ContributesAndroidInjector
	public abstract MainActivity contributeMainActivityInjector();
	
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
	public static StatisticsService provideStatisticsService() {
		return new StatisticsServiceImpl();
	}
}
