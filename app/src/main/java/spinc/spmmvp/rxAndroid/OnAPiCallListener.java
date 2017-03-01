package spinc.spmmvp.rxAndroid;

/**
 * Created by webwerks on 1/3/17.
 */

public interface OnAPiCallListener {
    void onNest(String message);

    void onError(String error);

    void onComplete();
}
