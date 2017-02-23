package spinc.spmmvp.mvp_pattern.Login;

import android.content.Context;
import android.text.TextUtils;

import spinc.spmmvp.mvp_pattern.RegisterFragment;
import spinc.spmmvp.utils.Utility;

/**
 * Created by webwerks on 15/2/17.
 */

public class LoginPresenter implements LoginInterface,LoginInteractorInterface{

    private Context context;
    private LoginInterface loginInterface;
    LoginInteractor loginInteractor;

    public LoginPresenter(Context mContext,LoginInterface mLoginInterface) {
        this.context = mContext;
        this.loginInterface = mLoginInterface;
        loginInteractor = new LoginInteractor(mContext,this);
    }

    @Override
    public void showProgress() {
        loginInterface.showProgress();
    }

    @Override
    public void hideProgress() {
        loginInterface.hideProgress();
    }

    @Override
    public void showSnackbarMessage(String message, boolean isAction, String actionName) {
        loginInterface.showSnackbarMessage(message,isAction,actionName);
    }

    @Override
    public void showErrorMessage(String message) {
        loginInterface.showErrorMessage(message);
    }

    @Override
    public void setLoginData(String loginData) {
        loginInterface.setLoginData(loginData);
    }

    @Override
    public void setRegisterData(String registerData) {
        loginInterface.setRegisterData(registerData);
    }

    @Override
    public void setEdittextError(int position, String message) {

    }

    @Override
    public void doLogin(String email,String password) {
        if(!Utility.isValidEmail(email)){
            loginInterface.setEdittextError(RegisterFragment.EMAIL_FIELD,"Invalid Email id");
        }
        else if(TextUtils.isEmpty(password) && password.length() < 6){
            loginInterface.setEdittextError(RegisterFragment.PASSWORD_FIELD,"Password must be 6 digit");
        }
       /* else if(Utility.isInternetAvailable(context)){
            loginInterface.showSnackbarMessage("No internet Connection",false,"");
        }*/
        else
            loginInteractor.doLogin( email, password);
    }

    @Override
    public void doRegister() {
        loginInteractor.doRegister();
    }
}
