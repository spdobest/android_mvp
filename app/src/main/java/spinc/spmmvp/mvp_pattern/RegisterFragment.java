package spinc.spmmvp.mvp_pattern;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import spinc.spmmvp.HomeActivity;
import spinc.spmmvp.R;
import spinc.spmmvp.base.BaseFragment;
import spinc.spmmvp.mvp_pattern.register.RegisterInterface;
import spinc.spmmvp.mvp_pattern.register.RegisterPresenter;

/**
 * Created by webwerks on 15/2/17.
 */

public class RegisterFragment extends BaseFragment implements RegisterInterface,View.OnClickListener {

    public static final String TAG = "LoginFragment";
    public static final int NAME_FIELD = 1;
    public static final int EMAIL_FIELD = 2;
    public static final int PASSWORD_FIELD = 3;


    AppCompatEditText editTextNameRegister;
    TextInputLayout tilNameRegister;
    AppCompatEditText editTextEmailRegister;
    TextInputLayout tilEmailRegister;
    AppCompatEditText editTextPasswordRegister;
    TextInputLayout tilPasswordRegister;
    AppCompatButton buttonRegisterRegScreen;
    AppCompatButton buttonLoginRegScreen;
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
        initView(rootView);
        return rootView;
    }

    @Override
    protected void initView(View rootview) {
        editTextNameRegister = (AppCompatEditText) rootView.findViewById(R.id.editTextNameRegister);
        tilNameRegister = (TextInputLayout) rootView.findViewById(R.id.tilNameRegister);
        editTextEmailRegister = (AppCompatEditText) rootView.findViewById(R.id.editTextEmailRegister);
        tilEmailRegister = (TextInputLayout) rootView.findViewById(R.id.tilEmailRegister);
        editTextPasswordRegister = (AppCompatEditText) rootView.findViewById(R.id.editTextPasswordRegister);
        tilPasswordRegister = (TextInputLayout) rootView.findViewById(R.id.tilPasswordRegister);
        buttonRegisterRegScreen = (AppCompatButton) rootView.findViewById(R.id.buttonRegisterRegScreen);
        buttonLoginRegScreen = (AppCompatButton) rootView.findViewById(R.id.buttonLoginRegScreen);
        linearLayoutRootLogin = (LinearLayout) rootView.findViewById(R.id.linearLayoutRootLogin);

        setClicklistener();

    }

    @Override
    protected void setClicklistener() {
        buttonLoginRegScreen.setOnClickListener(this);
        buttonRegisterRegScreen.setOnClickListener(this);
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


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonLoginRegScreen :
                ((HomeActivity)getActivity()).loadLoginScreen();
                break;
            case R.id.buttonRegisterRegScreen :
                registerPresenter.doRegister(editTextNameRegister.getText().toString().trim(),
                        editTextEmailRegister.getText().toString().trim(),
                        editTextPasswordRegister.getText().toString().trim()
                );
                break;
        }
    }
}
