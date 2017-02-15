package spinc.spmmvp.fragment.register;

import android.content.Context;
import android.os.Handler;

/**
 * Created by webwerks on 15/2/17.
 */

public class RegisterInteractor implements RegisterInteractorInterface {

    private Context context;
    private RegisterInterface registerInterface;

    public RegisterInteractor(Context mContext,RegisterInterface mRegisterInterface) {
        this.context = mContext;
        this.registerInterface = mRegisterInterface;
    }

    @Override
    public void doLogin() {
        registerInterface.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                registerInterface.hideProgress();
                registerInterface.setLoginData("Login Successfully");
            }
        },2000);
    }

    @Override
    public void doRegister(String name , String email,String password) {
        registerInterface.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                registerInterface.hideProgress();
                registerInterface.setRegisterData("Register Successfully");
            }
        },2000);
    }
}
