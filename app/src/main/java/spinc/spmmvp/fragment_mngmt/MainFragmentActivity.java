package spinc.spmmvp.fragment_mngmt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import spinc.spmmvp.R;

/**
 * Created by webwerks on 16/2/17.
 */

public class MainFragmentActivity extends AppCompatActivity implements View.OnClickListener{


    // http://stackoverflow.com/questions/5802141/is-this-the-right-way-to-clean-up-fragment-back-stack-when-leaving-a-deeply-nest

    public static final String TAG = "MainFragmentActivity";
    LinearLayout container;

    AppCompatButton buttonFragmentA;
    AppCompatButton buttonFragmentB;
    AppCompatButton buttonFragmentC;
    AppCompatButton buttonFragmentD;

    AppCompatButton buttonClearAllLoadA;
    AppCompatButton buttonAddFragmentB;
    AppCompatButton buttonclearLastfragment;

    FragmentUtilsMain fragmentUtilsMain;

    @Override
    public void onBackPressed() {
        Log.i(TAG, "onBackPressed: "+fragmentUtilsMain.getBackStackEntryCount());
        if(fragmentUtilsMain.getBackStackEntryCount()>0)
            fragmentUtilsMain.popBackStack(true);
        else
            super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        fragmentUtilsMain = new FragmentUtilsMain(MainFragmentActivity.this);

        initView();
    }

    private void initView() {
        buttonFragmentA = (AppCompatButton) findViewById(R.id.buttonFragmentA);
        buttonFragmentB = (AppCompatButton) findViewById(R.id.buttonFragmentB);
        buttonFragmentC = (AppCompatButton) findViewById(R.id.buttonFragmentC);
        buttonFragmentD = (AppCompatButton) findViewById(R.id.buttonFragmentD);

        buttonClearAllLoadA = (AppCompatButton) findViewById(R.id.buttonClearAllLoadA);
        buttonAddFragmentB = (AppCompatButton) findViewById(R.id.buttonAddFragmentB);
        buttonclearLastfragment = (AppCompatButton) findViewById(R.id.buttonclearLastfragment);

        setClickListener();
    }

    void setClickListener() {
        buttonFragmentA.setOnClickListener(this);
        buttonFragmentB.setOnClickListener(this);
        buttonFragmentC.setOnClickListener(this);
        buttonFragmentD.setOnClickListener(this);
        buttonClearAllLoadA.setOnClickListener(this);
        buttonAddFragmentB.setOnClickListener(this);
        buttonclearLastfragment.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonFragmentA :
                fragmentUtilsMain.startFragment(FragmentA.newInstance(),R.id.container,true);
                break;
            case R.id.buttonFragmentB :
                fragmentUtilsMain.startFragment(FragmentB.newInstance(),R.id.container,true);
                break;
            case R.id.buttonFragmentC :
                fragmentUtilsMain.startFragment(FragmentC.newInstance(),R.id.container,true);
                break;
            case R.id.buttonFragmentD :
                fragmentUtilsMain.startFragment(FragmentD.newInstance(),R.id.container,true);
                break;



            case R.id.buttonClearAllLoadA :
                Log.i(TAG, "onClick: "+fragmentUtilsMain.getBackStackEntryCount());
                fragmentUtilsMain.clearBackStackLoadSingleFragment(FragmentA.newInstance(),R.id.container,false);
                Log.i(TAG, "onClick: "+fragmentUtilsMain.getBackStackEntryCount());
                break;
            case R.id.buttonAddFragmentB :

                break;
            case R.id.buttonclearLastfragment :

                break;

        }
    }
}
