package io.rong.app10;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by Bob on 15/7/14.
 */
public class App extends Application {
    //userid
    public static String mTargetID = "47582";

    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
