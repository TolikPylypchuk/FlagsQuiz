package ua.edu.lnu.ami.flagsquiz.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

import ua.edu.lnu.ami.flagsquiz.FlagsQuizApp;
import ua.edu.lnu.ami.flagsquiz.services.*;

/**
 * <p>
 *     Represents a mediator between the {@link FlagsQuizAppModule} and classes
 *     that use the dependencies provided by the module.
 * </p>
 */
@Component(modules = { AndroidInjectionModule.class, FlagsQuizAppModule.class })
@Singleton
public interface FlagsQuizAppComponent extends AndroidInjector<FlagsQuizApp> {
	CountryService provideCountryService();
	RegionService provideRegionService();
	PreferencesService providePreferencesService();
	StatisticsService provideStatisticsService();
	
	@Component.Builder
	abstract class Builder extends AndroidInjector.Builder<FlagsQuizApp> {
		
		@Override
		public abstract FlagsQuizAppComponent build();
	}
}
