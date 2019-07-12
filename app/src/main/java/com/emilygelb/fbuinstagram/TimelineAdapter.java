package com.emilygelb.fbuinstagram;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.emilygelb.fbuinstagram.fragments.DetailsFragment;
import com.emilygelb.fbuinstagram.model.Post;

import java.util.List;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {

    private List<Post> mPosts;
    private Context mContext;

    public TimelineAdapter(Context context, List<Post> posts) {
        mPosts = posts;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_post, parent, false);
        return  new ViewHolder(view,mContext);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = mPosts.get(position);
        holder.bind(post);
    }


    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView ivImagePost;
        TextView caption;
        TextView handle;
        TextView tvUsername;
        TextView tvTimeStamp;

        public ViewHolder(View itemView, final Context context) {
            super(itemView);
            ivImagePost = (ImageView)itemView.findViewById(R.id.ivImagePost);
            caption = (TextView)itemView.findViewById(R.id.tvCaption);
            handle = (TextView) itemView.findViewById(R.id.tvHandle);
            tvUsername = (TextView) itemView.findViewById(R.id.tvUsername);
            tvTimeStamp = itemView.findViewById(R.id.tvTimeStamp);

            // Navigate to post details activity on click of post view.
            itemView.setOnClickListener((View.OnClickListener)this);
        }

       @Override
        public void onClick(View v) {
            Log.d("Adapter", "item clicked");
            final Post post = mPosts.get(getAdapterPosition());
            if (post != null) {
                Fragment fragment = new DetailsFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable("Post", post);
                fragment.setArguments(bundle);

                HomeActivity.fragmentManager.beginTransaction()
                        .replace(R.id.flContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        }

        public void bind(Post post) {
            handle.setText(post.getUser().getUsername());

            Glide.with(mContext)
                    .load(post.getImage().getUrl())
                    .into(ivImagePost);

            caption.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());
            tvTimeStamp.setText(post.getRelativeTime());
        }
    }

    // Clean all elements of the recycler
    public void clear() {
        mPosts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        mPosts.addAll(list);
        notifyDataSetChanged();
    }
}