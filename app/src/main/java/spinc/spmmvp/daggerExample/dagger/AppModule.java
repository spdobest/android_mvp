package spinc.spmmvp.daggerExample.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import spinc.spmmvp.daggerExample.ProntoShopApplication;
import spinc.spmmvp.daggerExample.interfaceImpl.HelloService;
import spinc.spmmvp.daggerExample.interfaceImpl.HelloServiceManager;

@Module
public class AppModule {
    private final ProntoShopApplication app;
    public AppModule(ProntoShopApplication app) {
        this.app = app;
    }
    @Provides
    @Singleton
    public Context provideContext() {
        return app;
    }

    @Provides
    @Singleton
    HelloService provideHelloService() {
        return new HelloServiceManager();
    }
}