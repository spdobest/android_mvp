package spinc.spmmvp.rxAndroid.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import spinc.spmmvp.rxAndroid.ApiService;

/**
 * Created by webwerks on 1/3/17.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    public ApiService provideApiService() {
        return new ApiService();
    }
}
