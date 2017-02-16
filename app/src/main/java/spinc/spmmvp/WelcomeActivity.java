package spinc.spmmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import spinc.spmmvp.fragment_mngmt.FragmentA;
import spinc.spmmvp.fragment_mngmt.FragmentUtilsMain;
import spinc.spmmvp.fragment_mngmt.MainFragmentActivity;
import spinc.spmmvp.google_vision.barcodeReader.MainActivity;
import spinc.spmmvp.google_vision.facetracker.FaceTrackerActivity;
import spinc.spmmvp.google_vision.googlyEyes.GooglyEyesActivity;
import spinc.spmmvp.google_vision.multitracker.MultiTrackerActivity;
import spinc.spmmvp.google_vision.ocrReader_start.OcrCaptureActivity;
import spinc.spmmvp.google_vision.photo_demo.photo.PhotoViewerActivity;

/**
 * Created by webwerks on 16/2/17.
 */

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton buttonHome;
    AppCompatButton buttonBarcodeReader;
    AppCompatButton buttonFaceTracker;
    AppCompatButton buttonGoogleEye;
    AppCompatButton buttonMultiTracker;
    AppCompatButton buttonOcrReader;
    AppCompatButton buttonPhotoDemo;

    AppCompatButton buttonOcrReadStart;
    AppCompatButton buttonOcrReadComplete;
    FragmentUtilsMain fragmentUtilsMain;

    LinearLayout llButtonContainer;
    FrameLayout frameLayoutOverlay;
    ToggleButton toggleFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        fragmentUtilsMain = new FragmentUtilsMain(WelcomeActivity.this);


         buttonHome = (AppCompatButton) findViewById(R.id.buttonHome);
         buttonBarcodeReader = (AppCompatButton) findViewById(R.id.buttonBarcodeReader);
         buttonFaceTracker = (AppCompatButton) findViewById(R.id.buttonFaceTracker);
         buttonGoogleEye = (AppCompatButton) findViewById(R.id.buttonGoogleEye);
         buttonMultiTracker = (AppCompatButton) findViewById(R.id.buttonMultiTracker);
         buttonOcrReader = (AppCompatButton) findViewById(R.id.buttonOcrReader);
         buttonPhotoDemo = (AppCompatButton) findViewById(R.id.buttonPhotoDemo);

        buttonOcrReadStart = (AppCompatButton) findViewById(R.id.buttonOcrReadStart);
        buttonOcrReadComplete = (AppCompatButton) findViewById(R.id.buttonOcrReadComplete);
        llButtonContainer  = (LinearLayout) findViewById(R.id.llButtonContainer);
        frameLayoutOverlay = (FrameLayout) findViewById(R.id.frameLayoutOverlay);
        toggleFragment = (ToggleButton) findViewById(R.id.toggleFragment);


        buttonHome.setOnClickListener(this);
        buttonBarcodeReader.setOnClickListener(this);
        buttonFaceTracker.setOnClickListener(this);
        buttonGoogleEye.setOnClickListener(this);
        buttonMultiTracker.setOnClickListener(this);
        buttonOcrReader.setOnClickListener(this);
        buttonPhotoDemo.setOnClickListener(this);

        buttonOcrReadStart.setOnClickListener(this);
        buttonOcrReadComplete.setOnClickListener(this);
        frameLayoutOverlay.setOnClickListener(this);

        fragmentUtilsMain.startFragment(FragmentTag.newInstance(),R.id.containerWelcome,true);
        toggleFragment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    frameLayoutOverlay.setVisibility(View.VISIBLE);
                    fragmentUtilsMain.startFragment(FragmentTag.newInstance(),R.id.containerWelcome,true);
                }
                else{
                    frameLayoutOverlay.setVisibility(View.GONE);
                    fragmentUtilsMain.clearBackStack();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonHome :
                startActivity(new Intent(WelcomeActivity.this,HomeActivity.class));
                break;
            case R.id.buttonBarcodeReader :
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                break;
            case R.id.buttonFaceTracker :
                startActivity(new Intent(WelcomeActivity.this,FaceTrackerActivity.class));
                break;
            case R.id.buttonGoogleEye :
                startActivity(new Intent(WelcomeActivity.this,GooglyEyesActivity.class));
                break;
            case R.id.buttonMultiTracker :
                startActivity(new Intent(WelcomeActivity.this,MultiTrackerActivity.class));
                break;
            case R.id.buttonOcrReader :
                startActivity(new Intent(WelcomeActivity.this,spinc.spmmvp.google_vision.ocrReader.MainActivity.class));
                break;
            case R.id.buttonPhotoDemo :
                startActivity(new Intent(WelcomeActivity.this,PhotoViewerActivity.class));
                break;
            case R.id.buttonOcrReadStart :
                startActivity(new Intent(WelcomeActivity.this,OcrCaptureActivity.class));
                break;
            case R.id.buttonOcrReadComplete :
                startActivity(new Intent(WelcomeActivity.this, spinc.spmmvp.google_vision.ocrRead_Complete.OcrCaptureActivity.class));
                break;
            case R.id.frameLayoutOverlay :
                frameLayoutOverlay.setVisibility(View.GONE);
                fragmentUtilsMain.clearBackStack();
                toggleFragment.setChecked(false);
                break;
        }
    }
}
