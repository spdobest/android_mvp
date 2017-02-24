package spinc.spmmvp.rxjava;

import android.util.Log;

import rx.Observable;
import rx.Observer;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by webwerks on 24/2/17.
 */

public class MyObsercer implements Observer<Object> {

    @Override
    public void onCompleted() {
        // Called when the observable has no more data to emit
    }

    @Override
    public void onError(Throwable e) {
        // Called when the observable encounters an error
    }

    @Override
    public void onNext(Object o) {
// Called each time the observable emits data
        Log.d("MY OBSERVER", o.toString());
    }
}
