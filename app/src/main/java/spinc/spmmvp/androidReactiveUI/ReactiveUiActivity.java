package spinc.spmmvp.androidReactiveUI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;
import spinc.spmmvp.R;

/**
 * Created by webwerks on 1/3/17.
 */

public class ReactiveUiActivity extends AppCompatActivity {

    Button buttonClick;

    EditText editTextTextChange;
    Subscription buttonSub;

    private CompositeSubscription compositeSubscription;

    @Override
    protected void onPause() {
        super.onPause();
        if (buttonSub.isUnsubscribed())
            buttonSub.unsubscribe();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reactive_ui);

        compositeSubscription = new CompositeSubscription();

        buttonClick = (Button) findViewById(R.id.buttonClick);
        editTextTextChange = (EditText) findViewById(R.id.editTextTextChange);

        buttonSub =
                RxView.clicks(buttonClick).subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        // do some work here
                        Toast.makeText(ReactiveUiActivity.this, "Button Click", Toast.LENGTH_SHORT).show();

                        getSupportFragmentManager().beginTransaction().add(R.id.llContainer,new MainActivityFragment(),MainActivityFragment.TAG).commit();

                    }
                });


    }
}
