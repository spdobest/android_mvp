package spinc.spmmvp.rxAndroid.dagger;

import javax.inject.Singleton;

import dagger.Component;
import spinc.spmmvp.rxAndroid.ApiService;
import spinc.spmmvp.rxAndroid.RxActivityExample;

@Singleton
@Component(
        modules = {
                AppModule.class,
                ApiService.class
        }
)
public interface AppComponent {
    void inject(RxActivityExample activity);
}