package spinc.spmmvp.mvvm;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import java.util.List;

import spinc.spmmvp.R;
import spinc.spmmvp.databinding.MvvmItemBinding;

/**
 * Created by milan on 17.8.16.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.BindingHolder> {

    private List<Article> mArticles;
    private Context mContext;

    public ArticleAdapter(List<Article> mArticles, Context mContext) {
        this.mArticles = mArticles;
        this.mContext = mContext;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MvvmItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.mvvm_item, parent, false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        MvvmItemBinding binding = holder.binding;
        binding.setAvm(new ArticleViewModel(mArticles.get(position), mContext));
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private MvvmItemBinding binding;

        public BindingHolder(MvvmItemBinding binding) {
            super(binding.contactCard);
            this.binding = binding;
        }
    }
}
