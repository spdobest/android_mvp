package spinc.spmmvp.androidReactiveUI;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxSeekBar;
import com.jakewharton.rxbinding.widget.RxTextView;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;
import spinc.spmmvp.R;

public class MainActivityFragment extends Fragment {
    public static final String TAG = "MainActivityFragment";
    private CompositeSubscription compositeSubscription;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        compositeSubscription = new CompositeSubscription();
        View v = inflater.inflate(R.layout.fragment_main_reactiveui, container, false);

        final ViewGroup viewContainer = (ViewGroup) v.findViewById(R.id.view_container);

        final TextView nameLabel = (TextView) v.findViewById(R.id.name_label);

        final EditText name = (EditText) v.findViewById(R.id.name);
        Subscription editTextSub =
                RxTextView.textChanges(name)
                        .map(new Func1<CharSequence, String>() {
                            @Override
                            public String call(CharSequence charSequence) {
                                return new StringBuilder(charSequence).reverse().toString();
                            }
                        })
                        .subscribe(new Action1<String>() {
                            @Override
                            public void call(String value) {
                                nameLabel.setText(value);
                            }
                        });
        compositeSubscription.add(editTextSub);

        Button b = (Button) v.findViewById(R.id.do_magic);
        Observable<Void> clickObservable = RxView.clicks(b).share();

        Subscription buttonSub =
                clickObservable.subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        name.setText(name.getText() + " Button was Clicked!");
                    }
                });
        compositeSubscription.add(buttonSub);

        Subscription loggingSub =
                clickObservable.subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
//                        Timber.d("Button was clicked!");
                    }
                });
        compositeSubscription.add(loggingSub);

        SeekBar colorSlider = (SeekBar) v.findViewById(R.id.color_slider);
        Subscription seekBarSub =
                RxSeekBar.userChanges(colorSlider).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer seekValue) {
                        viewContainer.setBackgroundColor(Color.argb(seekValue, 131, 255, 8));
                    }
                });
        compositeSubscription.add(seekBarSub);

        return v;
    }

    @Override
    public void onStop() {
        super.onStop();
        compositeSubscription.unsubscribe();
    }
}