package spinc.spmmvp.daggerExample.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import spinc.spmmvp.daggerExample.ShoppingCart;

@Module
public class ShoppingCartModule {

    public static String name = "sibaprasad";

    @Provides
    @Singleton
    SharedPreferences providesSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    ShoppingCart providesShoppingCart(SharedPreferences preferences) {
        return new ShoppingCart(preferences);
    }


}