package spinc.spmmvp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import spinc.spmmvp.HomeActivity;
import spinc.spmmvp.R;
import spinc.spmmvp.base.BaseFragment;
import spinc.spmmvp.fragment.Login.LoginInteractor;
import spinc.spmmvp.fragment.Login.LoginInterface;
import spinc.spmmvp.fragment.Login.LoginPresenter;

import static spinc.spmmvp.fragment.RegisterFragment.NAME_FIELD;

/**
 * Created by webwerks on 15/2/17.
 */

public class LoginFragment extends BaseFragment implements LoginInterface{

    public static final String TAG = "LoginFragment";

    public static final int EMAIL_FIELD = 2;
    public static final int PASSWORD_FIELD = 3;

    @BindView(R.id.linearLayoutRootLogin)
    LinearLayout linearLayoutRootLogin;

    @BindView(R.id.textInputEdittextEmail)
    TextInputEditText textInputEdittextEmail;

    @BindView(R.id.tilEmail)
    TextInputLayout tilEmail;

    @BindView(R.id.textInputEdittextPassword)
    TextInputEditText textInputEdittextPassword;

    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;

    @BindView(R.id.buttonLogin)
    AppCompatButton buttonLogin;

    @BindView(R.id.buttonRegister)
    AppCompatButton buttonRegister;

    private LoginPresenter loginPresenter;

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private View rootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenter(getActivity(),this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.buttonLogin)
    protected void onLoginClick(){
        loginPresenter.doLogin(textInputEdittextEmail.getText().toString().trim(),textInputEdittextPassword.getText().toString().trim());
    }

    @OnClick(R.id.buttonRegister)
    protected void onRegisterClick(){

    }

    @Override
    public void showProgress() {
        showProgressMain("Loading...");
    }

    @Override
    public void hideProgress() {
        hideProgressMain();
    }

    @Override
    public void showSnackbarMessage(String message, boolean isAction, String actionName) {
        showSnackBar(message);
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void setLoginData(String loginData) {
        showSnackBar(loginData);
    }

    @Override
    public void setRegisterData(String registerData) {
        showSnackBar(registerData);
        ((HomeActivity)getActivity()).loadRegisterScreen();
    }

    @Override
    public void setEdittextError(int position, String message) {
        switch (position){
            case EMAIL_FIELD :
                tilEmail.setEnabled(true);
                tilEmail.setError(message);
                break;
            case PASSWORD_FIELD :
                tilPassword.setEnabled(true);
                tilPassword.setError(message);
                break;
        }
    }

    void showSnackBar(String message){
        Snackbar snackbar = Snackbar
                .make(linearLayoutRootLogin, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
