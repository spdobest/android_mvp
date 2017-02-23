package spinc.spmmvp.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import spinc.spmmvp.R;

/**
 * Created by webwerks on 16/2/17.
 */

public class TagRecyclerViewAdapter extends RecyclerView.Adapter<TagRecyclerViewAdapter.TagViewHolder> {

    private static final String TAG = "TagRecyclerViewAdapter";
    private List<String> listTag;
    Context context;

    public TagRecyclerViewAdapter(Context context,List<String> moviesList) {
        this.context = context;
        this.listTag = moviesList;
    }

    @Override
    public TagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_tag, parent, false);

        return new TagViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TagViewHolder holder, int position) {
        holder.textViewItemTag.setText(listTag.get(position));
    }

    @Override
    public int getItemCount() {
        return listTag.size();
    }

    public class TagViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView textViewItemTag;
        public TagViewHolder(View itemView) {
            super(itemView);
            textViewItemTag = (AppCompatTextView) itemView.findViewById(R.id.textViewItemTag);
        }
    }
}
