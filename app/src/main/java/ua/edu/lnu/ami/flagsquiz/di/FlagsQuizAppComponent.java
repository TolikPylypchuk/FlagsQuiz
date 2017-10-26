package ua.edu.lnu.ami.flagsquiz.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import ua.edu.lnu.ami.flagsquiz.FlagsQuizApp;
import ua.edu.lnu.ami.flagsquiz.services.RegionService;

/**
 * <p>
 *     Represents a mediator between the {@link FlagsQuizAppModule} and classes
 *     that use the dependencies provided by the module.
 * </p>
 * @author Tolik Pylypchuk
 */
@Component(modules = { AndroidInjectionModule.class, FlagsQuizAppModule.class })
@Singleton
public interface FlagsQuizAppComponent extends AndroidInjector<FlagsQuizApp> {
	RegionService provideRegionService();
}
