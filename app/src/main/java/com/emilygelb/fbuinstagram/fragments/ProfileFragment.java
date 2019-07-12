package com.emilygelb.fbuinstagram.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.emilygelb.fbuinstagram.MainActivity;
import com.emilygelb.fbuinstagram.R;
import com.parse.ParseUser;

public class ProfileFragment extends Fragment {

    Button logout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        logout = view.findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                ParseUser currentUser = ParseUser.getCurrentUser();
            }
        });
    }
}


//public class ProfileFragment extends TimelineFragment {
//
//    private final String TAG = "ProfileFragment";
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//    }
//
//    @Override
//    protected void queryPost() {
//        ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
//        postQuery.include(Post.KEY_USER);
//        postQuery.setLimit(20);
//        postQuery.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
//        postQuery.addDescendingOrder(Post.KEY_CREATED_AT);
//        postQuery.findInBackground(new FindCallback<Post>() {
//            @Override
//            public void done(List<Post> posts, ParseException e) {
//                if (e != null) {
//                    Log.e(TAG, "Error with query");
//                    e.printStackTrace();
//                    return;
//                } else {
//                    mPosts.addAll(posts);
//                    adapter.notifyDataSetChanged();
//
//                    for (int i = 0; i < posts.size(); i++) {
//                        Post post = posts.get(i);
//                        Log.d(TAG, "Post: " + post.getDescription() + ", username: " + post.getUser().getUsername());
//                    }
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu, menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.action_logout){
//            Toast.makeText(getContext(), "Action", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
//
