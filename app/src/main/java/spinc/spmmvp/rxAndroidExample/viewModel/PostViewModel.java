package spinc.spmmvp.rxAndroidExample.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import spinc.spmmvp.rxAndroidExample.model.PostModel;

/**
 * Created by webwerks on 2/3/17.
 */

public class PostViewModel extends BaseObservable {
    PostModel postModel;
    Context context;

    public PostViewModel(Context context, PostModel postModel) {
        this.context = context;
        this.postModel = postModel;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(AppCompatImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }


    public String getTitle() {
        return postModel.title;
    }

    public String getImage() {
        return null;// postModel.imageUrl;
    }

    public String getBody() {
        return postModel.body;
    }

    public void setPost(PostModel postModel) {
        this.postModel = postModel;
        notifyChange();
    }

    public void onItemClick(View view) {
        Toast.makeText(context, "CLicked", Toast.LENGTH_SHORT).show();
    }
}
