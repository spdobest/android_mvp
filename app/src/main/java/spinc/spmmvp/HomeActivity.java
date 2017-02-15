package spinc.spmmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import spinc.spmmvp.fragment.LoginFragment;
import spinc.spmmvp.fragment.RegisterFragment;
import spinc.spmmvp.fragment.register.RegisterInterface;

public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        loadLoginScreen();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadRegisterScreen();
    }

    public void loadLoginScreen() {
        getSupportFragmentManager().beginTransaction().add(R.id.container, new LoginFragment(),LoginFragment.TAG);
    }

    public void loadRegisterScreen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, RegisterFragment.newInstance(),RegisterFragment.TAG);
    }
}
