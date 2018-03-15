package com.xjcrepe.aibo.di;

import com.xjcrepe.aibo.AiboApplication;
import com.xjcrepe.aibo.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        NetworkModule.class,
        ViewModelBuilder.class,
})
public interface AppComponent extends AndroidInjector<AiboApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<AiboApplication> {
    }
}
