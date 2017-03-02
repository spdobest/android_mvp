package spinc.spmmvp.rxAndroidExample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import spinc.spmmvp.R;
import spinc.spmmvp.rxAndroidExample.adapter.PostAdapter;
import spinc.spmmvp.rxAndroidExample.model.PostModel;
import spinc.spmmvp.rxAndroidExample.net.ForumService;

public class RxAndroidActivity extends AppCompatActivity implements Observer<Object> {

    private static final String TAG = "RxAndroidActivity";

    ForumService forumService;
    List<PostModel> listPost = new ArrayList<>();
    RecyclerView recyclerViewPost;
    PostAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_android);

        recyclerViewPost = (RecyclerView) findViewById(R.id.recyclerViewPost);

        adapter = new PostAdapter(this, listPost);
        recyclerViewPost.setAdapter(adapter);
        recyclerViewPost.setLayoutManager(new LinearLayoutManager(this));

        forumService = new ForumService();
        loadPost();
    }

    private void loadPost() {
        forumService.getApi()
                .getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void onCompleted() {
        Log.i(TAG, "onCompleted: " + listPost.size());
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(Object o) {
        List<Object> listObject = (List<Object>) o;
        if (listObject.get(0) instanceof PostModel) {
            listPost.addAll((List<PostModel>) o);
            adapter.notifyDataSetChanged();
            Log.i(TAG, "onNext: " + o.toString());
        }
    }
}
