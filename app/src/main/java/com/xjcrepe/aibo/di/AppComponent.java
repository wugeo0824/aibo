package com.xjcrepe.aibo.di;

import android.app.Application;

import com.xjcrepe.aibo.AiboApplication;
import com.xjcrepe.aibo.network.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
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
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(AiboApplication application);
}
