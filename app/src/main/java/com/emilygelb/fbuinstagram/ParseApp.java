package com.emilygelb.fbuinstagram;

import android.app.Application;

import com.emilygelb.fbuinstagram.model.Post;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        final Parse.Configuration configuration = new Parse.Configuration.Builder(this)
                .applicationId("instagram")
                .clientKey("facebook-u")
                .server("http://egelb-instagram-fbu.herokuapp.com/parse")
                .build();

        Parse.initialize(configuration);
    }
}
