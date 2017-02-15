package spinc.spmmvp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
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
import spinc.spmmvp.fragment.Login.LoginInterface;
import spinc.spmmvp.fragment.register.RegisterInterface;
import spinc.spmmvp.fragment.register.RegisterPresenter;

/**
 * Created by webwerks on 15/2/17.
 */

public class RegisterFragment extends BaseFragment implements RegisterInterface {

    public static final String TAG = "LoginFragment";
    public static final int NAME_FIELD = 1;
    public static final int EMAIL_FIELD = 2;
    public static final int PASSWORD_FIELD = 3;
    @BindView(R.id.textInputEdittextNameRegister)
    TextInputEditText textInputEdittextNameRegister;
    @BindView(R.id.tilNameRegister)
    TextInputLayout tilNameRegister;
    @BindView(R.id.textInputEdittextEmailRegister)
    TextInputEditText textInputEdittextEmailRegister;
    @BindView(R.id.tilEmailRegister)
    TextInputLayout tilEmailRegister;
    @BindView(R.id.textInputEdittextPasswordRegister)
    TextInputEditText textInputEdittextPasswordRegister;
    @BindView(R.id.tilPasswordRegister)
    TextInputLayout tilPasswordRegister;
    @BindView(R.id.buttonRegisterRegScreen)
    AppCompatButton buttonRegisterRegScreen;
    @BindView(R.id.buttonLoginRegScreen)
    AppCompatButton buttonLoginRegScreen;
    @BindView(R.id.linearLayoutRootLogin)
    LinearLayout linearLayoutRootLogin;
    RegisterPresenter registerPresenter;
    private View rootView;

    public static RegisterFragment newInstance() {

        Bundle args = new Bundle();

        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerPresenter = new RegisterPresenter(getActivity(), this);
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
        rootView = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.buttonLogin)
    protected void onLoginClick() {

    }

    @OnClick(R.id.buttonRegister)
    protected void onRegisterClick() {
        registerPresenter.doRegister(textInputEdittextNameRegister.getText().toString().trim(),
                textInputEdittextEmailRegister.getText().toString().trim(),
                textInputEdittextPasswordRegister.getText().toString().trim()
                );
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
        ((HomeActivity)getActivity()).loadLoginScreen();
    }

    @Override
    public void setRegisterData(String registerData) {
        showSnackBar(registerData);
    }

    @Override
    public void setEdittextError(int position,String message) {
        switch (position) {
            case NAME_FIELD:
                tilNameRegister.setEnabled(true);
                tilNameRegister.setError(message);
                break;
            case EMAIL_FIELD:
                tilEmailRegister.setEnabled(true);
                tilEmailRegister.setError(message);
                break;
            case PASSWORD_FIELD:
                tilPasswordRegister.setEnabled(true);
                tilPasswordRegister.setError(message);
                break;
        }
    }

    void showSnackBar(String message) {
        Snackbar snackbar = Snackbar
                .make(linearLayoutRootLogin, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }


}
