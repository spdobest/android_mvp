package spinc.spmmvp.espresso;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import spinc.spmmvp.R;

/**
 * Created by webwerks on 22/2/17.
 */

public class TestActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout linearLayoutRootLogin;
    AppCompatEditText edittextEmail;
    TextInputLayout tilEmail;

    AppCompatEditText edittextPassword;
    TextInputLayout tilPassword;
    AppCompatButton buttonLogin;
    AppCompatButton buttonRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        initView( );
    }
    protected void initView( ) {
        linearLayoutRootLogin = (LinearLayout) findViewById(R.id.linearLayoutRootLogin);
        edittextEmail = (AppCompatEditText) findViewById(R.id.edittextEmail);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        edittextPassword = (AppCompatEditText) findViewById(R.id.edittextPassword);
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        buttonLogin = (AppCompatButton) findViewById(R.id.buttonLogin);
        buttonRegister = (AppCompatButton) findViewById(R.id.buttonRegister);

        setClicklistener();

    }

    protected void setClicklistener() {
        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.buttonRegister :

                break;
        }
    }
    public void greet(View v) {
        edittextEmail.setText(getString(R.string.greet));
//        Toast.makeText(TestActivity.this, "hello", Toast.LENGTH_SHORT).show();
    }
}
