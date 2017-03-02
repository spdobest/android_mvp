package spinc.spmmvp.rxAndroidExample.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import spinc.spmmvp.daggerExample.interfaceImpl.HelloService;
import spinc.spmmvp.daggerExample.interfaceImpl.HelloServiceManager;
import spinc.spmmvp.rxAndroidExample.net.ForumService;

@Module
public class PostModule {
    @Provides
    @Singleton
    ForumService provideHelloService() {
        return new ForumService();
    }
}