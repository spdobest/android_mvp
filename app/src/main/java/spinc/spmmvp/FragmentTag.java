package spinc.spmmvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import spinc.spmmvp.adapter.TagRecyclerViewAdapter;
import spinc.spmmvp.base.BaseFragment;

/**
 * Created by webwerks on 16/2/17.
 */

public class FragmentTag extends BaseFragment {

    private static final String TAG = "FragmentTag";
    View rootView;
    RecyclerView recyclerViewTag;
    TagRecyclerViewAdapter tagRecyclerViewAdapter;
    List<String> listTag = new ArrayList<>();


    public static FragmentTag newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentTag fragment = new FragmentTag();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tag,container,false);
        initView(rootView);
        return rootView;
    }

    @Override
    protected void initView(View rootview) {
        recyclerViewTag = (RecyclerView) rootview.findViewById(R.id.recyclerViewTag);
        recyclerViewTag.setLayoutManager(new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL,false));
        for(int i = 0;i<20;i++){
            listTag.add("Sibaprasad");
        }
        tagRecyclerViewAdapter = new TagRecyclerViewAdapter(getActivity(),listTag);
        recyclerViewTag.setAdapter(tagRecyclerViewAdapter);
    }

    @Override
    protected void setClicklistener() {

    }
}
