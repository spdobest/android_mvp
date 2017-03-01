package spinc.spmmvp.rxAndroid;

import android.content.Context;

import rx.Observer;

/**
 * Created by webwerks on 1/3/17.
 */

public class ApiService {
    static ApiService apiService;

    public static ApiService getInstance(Context context) {
        if (apiService == null)
            apiService = new ApiService();
        return apiService;
    }

    public void makeApiCall(OnAPiCallListener onAPiCallListener) {
        onAPiCallListener.onComplete();
        onAPiCallListener.onError("");
        onAPiCallListener.onNest("");
    }

    public void makeRxApiCall(Observer<Object> objectObserver) {

    }

}
