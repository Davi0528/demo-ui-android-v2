package io.rong.imkit.demo.eight;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by zhjchen on 7/10/15.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        RongIM.init(this);
    }
}
