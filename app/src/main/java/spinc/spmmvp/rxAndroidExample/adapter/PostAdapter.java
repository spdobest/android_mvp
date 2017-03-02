package spinc.spmmvp.rxAndroidExample.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import spinc.spmmvp.R;
import spinc.spmmvp.rxAndroidExample.model.PostModel;

/**
 * Created by webwerks on 2/3/17.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<PostModel> listPostModel;
    Context context;
    public String imageUrl = "http://lorempixel.com/400/200/";
    public PostAdapter(Context context, List<PostModel> listPost) {
        this.context = context;
        this.listPostModel = listPost;
    }


    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_post, parent, false);

        PostViewHolder dataObjectHolder = new PostViewHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        PostModel postModel = listPostModel.get(position);
        holder.textViewTitle.setText(postModel.title);
        holder.textViewBody.setText(postModel.body);
        Glide.with(context).load(imageUrl).into(holder.imageViewItemPost);
    }

    @Override
    public int getItemCount() {
        return listPostModel.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageViewItemPost;
        AppCompatTextView textViewTitle;
        AppCompatTextView textViewBody;

        public PostViewHolder(View itemView) {
            super(itemView);
            imageViewItemPost = (AppCompatImageView) itemView.findViewById(R.id.imageViewItemPost);
            textViewTitle = (AppCompatTextView) itemView.findViewById(R.id.textViewTitle);
            textViewBody = (AppCompatTextView) itemView.findViewById(R.id.textViewBody);
        }
    }

}
