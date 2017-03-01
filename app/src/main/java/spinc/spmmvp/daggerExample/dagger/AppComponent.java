package spinc.spmmvp.daggerExample.dagger;

import javax.inject.Singleton;

import dagger.Component;
import spinc.spmmvp.daggerExample.DaggerActivity;
import spinc.spmmvp.daggerExample.ProductListener;

@Singleton
@Component(
        modules = {
                AppModule.class,
                ShoppingCartModule.class
        }
)
public interface AppComponent {
    void inject(ProductListener presenter);
    void inject(DaggerActivity activity);
}