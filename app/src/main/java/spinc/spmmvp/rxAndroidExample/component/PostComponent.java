package spinc.spmmvp.rxAndroidExample.component;

import javax.inject.Singleton;

import dagger.Component;
import spinc.spmmvp.rxAndroidExample.RxAndroidActivity;
import spinc.spmmvp.rxAndroidExample.module.PostModule;

@Singleton
@Component(
        modules = {
                PostModule.class,
        }
)
public interface PostComponent {
    void inject(RxAndroidActivity activity);
}