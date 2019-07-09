package com.emilygelb.fbuinstagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.emilygelb.fbuinstagram.model.Post;

import java.util.List;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {
    private List<Post> mPosts;
    private Context mContext;
    private String mUserId;

    public TimelineAdapter(Context context, String userId, List<Post> posts) {
        mPosts = posts;
        this.mUserId = userId;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_post, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = mPosts.get(position);

        ImageView profileView = holder.ivImagePost;
        Glide.with(mContext)
                .load(post.getImage().getUrl())
                .into(profileView);
        holder.caption.setText(post.getDescription());
        holder.handle.setText(post.getUser().getUsername());
    }


    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagePost;
        TextView caption;
        TextView handle;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImagePost = (ImageView)itemView.findViewById(R.id.ivImagePost);
            caption = (TextView)itemView.findViewById(R.id.tvCaption);
            handle = (TextView) itemView.findViewById(R.id.tvHandle);
        }
    }
}