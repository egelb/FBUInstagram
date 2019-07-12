package com.emilygelb.fbuinstagram.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.emilygelb.fbuinstagram.R;
import com.emilygelb.fbuinstagram.model.Post;

public class DetailsFragment extends Fragment {

    private final String TAG = "DetailsFragment";

    TextView tvHandle;
    TextView userName;
    TextView caption;
    TextView timeStamp;
    ImageView ivImagePost;
    Post post;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details,container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        post = (Post) bundle.getSerializable("Post");

        tvHandle = view.findViewById(R.id.tvHandle);
        userName = view.findViewById(R.id.tvUsername);
        caption = view.findViewById(R.id.tvCaption);
        timeStamp = view.findViewById(R.id.tvTimeStamp);
        ivImagePost = view.findViewById(R.id.ivImagePost);

        tvHandle.setText(post.getUser().getUsername());
        userName.setText(post.getUser().getUsername());
        caption.setText(post.getDescription());
        timeStamp.setText(post.getRelativeTime());

        Glide.with(getContext())
                .load(post.getImage().getUrl())
                .into(ivImagePost);

    }
}
