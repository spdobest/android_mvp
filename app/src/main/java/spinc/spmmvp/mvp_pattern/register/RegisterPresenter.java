package spinc.spmmvp.mvp_pattern.register;

import android.content.Context;
import android.text.TextUtils;

import spinc.spmmvp.mvp_pattern.RegisterFragment;
import spinc.spmmvp.utils.Utility;

/**
 * Created by webwerks on 15/2/17.
 */

public class RegisterPresenter implements RegisterInterface,RegisterInteractorInterface{

    private Context context;
    private RegisterInterface registerInterface;
    RegisterInteractor registerInteractor;

    public RegisterPresenter(Context mContext,RegisterInterface mregisterInterface) {
        this.context = mContext;
        this.registerInterface = mregisterInterface;
        registerInteractor = new RegisterInteractor(mContext,this);
    }

    @Override
    public void showProgress() {
        registerInterface.showProgress();
    }

    @Override
    public void hideProgress() {
        registerInterface.hideProgress();
    }

    @Override
    public void showSnackbarMessage(String message, boolean isAction, String actionName) {
        registerInterface.showSnackbarMessage(message,isAction,actionName);
    }

    @Override
    public void showErrorMessage(String message) {
        registerInterface.showErrorMessage(message);
    }

    @Override
    public void setLoginData(String loginData) {
        registerInterface.setLoginData(loginData);
    }

    @Override
    public void setRegisterData(String registerData) {
        registerInterface.setRegisterData(registerData);
    }

    @Override
    public void doLogin( ) {
        registerInteractor.doLogin( );
    }

    @Override
    public void doRegister(String name , String email,String password) {
        if(TextUtils.isEmpty(name)){
            registerInterface.setEdittextError(RegisterFragment.NAME_FIELD,"Name cant be empty");
        }
        else if(Utility.isValidEmail(email)){
            registerInterface.setEdittextError(RegisterFragment.EMAIL_FIELD,"Invalid Email id");
        }
        else if(TextUtils.isEmpty(password) && password.length() < 6){
            registerInterface.setEdittextError(RegisterFragment.PASSWORD_FIELD,"Password must be 6 digit");
        }
        else if(Utility.isInternetAvailable(context)){
            registerInterface.showSnackbarMessage("No internet Connection",false,"");
        }
        else
            registerInteractor.doRegister( name , email, password);
    }
    @Override
    public void setEdittextError(int position, String message) {

    }
}
