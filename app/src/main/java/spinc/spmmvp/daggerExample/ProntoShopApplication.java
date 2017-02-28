package spinc.spmmvp.daggerExample;

import android.app.Application;

import spinc.spmmvp.daggerExample.dagger.AppComponent;
import spinc.spmmvp.daggerExample.dagger.AppModule;
import spinc.spmmvp.daggerExample.dagger.DaggerAppComponent;

public class ProntoShopApplication extends Application {

        private static ProntoShopApplication instance = new ProntoShopApplication();
        private static AppComponent appComponent;

        public static ProntoShopApplication getInstance() {
            return instance;
        }

        @Override
        public void onCreate() {
            super.onCreate();
            getAppComponent();
        }

        public AppComponent getAppComponent() {
            if (appComponent == null){
                appComponent = DaggerAppComponent.builder()
                        .appModule(new AppModule(this))
                        .build();
            }
            return appComponent;
        }

}