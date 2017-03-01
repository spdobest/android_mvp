package spinc.spmmvp.rxAndroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import spinc.spmmvp.R;

/**
 * Created by webwerks on 1/3/17.
 */

public class RxActivityExample extends AppCompatActivity{

    @Inject ApiService apiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        apiService.makeApiCall(new OnAPiCallListener() {
            @Override
            public void onNest(String message) {

            }

            @Override
            public void onError(String error) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}
