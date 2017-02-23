package spinc.spmmvp.fragment_mngmt;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import spinc.spmmvp.R;
import spinc.spmmvp.base.BaseFragment;

/**
 * Created by webwerks on 16/2/17.
 */

public class FragmentB extends BaseFragment implements FragmentManager.OnBackStackChangedListener {
    public static final String TAG = "FragmentB";
    View rootView;
    RelativeLayout relativeRootFragment;
    AppCompatTextView textViewFragmentName;
    AppCompatImageView imageViewSmiley;


    public static FragmentB newInstance() {

        Bundle args = new Bundle();

        FragmentB fragment = new FragmentB();
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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_layout,container,false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void initView(View rootview) {
        relativeRootFragment = (RelativeLayout) rootview.findViewById(R.id.relativeRootFragment);
        textViewFragmentName = (AppCompatTextView) rootview.findViewById(R.id.textViewFragmentName);
        imageViewSmiley = (AppCompatImageView) rootview.findViewById(R.id.imageViewSmiley);

        int color = Color.parseColor("#E9967A"); //The color u want
        imageViewSmiley.setColorFilter(color);
        textViewFragmentName.setText(TAG);
        setClicklistener();
    }

    @Override
    protected void setClicklistener() {

    }

    @Override
    public void onBackStackChanged() {
        Log.i(TAG, "onBackStackChanged: B ");
    }
}
