package spinc.spmmvp.mvp_pattern.Login;

import android.content.Context;
import android.os.Handler;

/**
 * Created by webwerks on 15/2/17.
 */

public class LoginInteractor implements LoginInteractorInterface{

    private Context context;
    private LoginInterface loginInterface;

    public LoginInteractor(Context mContext,LoginInterface mLoginInterface) {
        this.context = mContext;
        this.loginInterface = mLoginInterface;
    }

    @Override
    public void doLogin(String email,String password) {
        loginInterface.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginInterface.hideProgress();
                loginInterface.setLoginData("Login Successfully");
            }
        },2000);
    }

    @Override
    public void doRegister() {
        loginInterface.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginInterface.hideProgress();
                loginInterface.setRegisterData("Register Successfully");
            }
        },2000);
    }
}
