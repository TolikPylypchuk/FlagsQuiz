package ua.edu.lnu.ami.flagsquiz.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

import ua.edu.lnu.ami.flagsquiz.MainActivity;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;
import ua.edu.lnu.ami.flagsquiz.services.impl.RegionServiceImpl;

/**
 * <p>Represents a module which provides Dagger with necessary instances.</p>
 * @author Tolik Pylypchuk
 */
@Module
public abstract class FlagsQuizAppModule {
	
	@ContributesAndroidInjector
	public abstract MainActivity contributeActivityInjector();
	
	@Provides
	@Singleton
	public static RegionService provideRegionService() {
		return new RegionServiceImpl();
	}
}
