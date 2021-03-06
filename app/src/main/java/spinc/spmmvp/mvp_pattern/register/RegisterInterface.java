package spinc.spmmvp.mvp_pattern.register;

/**
 * Created by webwerks on 15/2/17.
 */

public interface RegisterInterface {

    void showProgress();
    void hideProgress();
    void showSnackbarMessage(String message, boolean isAction, String actionName);
    void showErrorMessage(String message);

    void setLoginData(String loginData);
    void setRegisterData(String registerData);

    void setEdittextError(int position, String message);

}
