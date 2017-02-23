package spinc.spmmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import spinc.spmmvp.mvp_pattern.LoginFragment;
import spinc.spmmvp.mvp_pattern.RegisterFragment;

public class HomeActivity extends AppCompatActivity {


    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loadLoginScreen();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void loadLoginScreen() {
        getFragmentManager().beginTransaction().add(R.id.container, new LoginFragment(), LoginFragment.TAG).commit();
    }

    public void loadRegisterScreen() {
        getFragmentManager().beginTransaction().replace(R.id.container, RegisterFragment.newInstance(), RegisterFragment.TAG).commit();
    }
}
