package io.rong.imkit.demo.eight;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * Created by zhjchen on 7/10/15.
 */

public class StartActivity extends Activity {

    Button mConnectBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        mConnectBtn = (Button) findViewById(android.R.id.button1);

        mConnectBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mConnectBtn.setText("连接中。。。");

                RongIM.connect("XHene7b6y2HZD9nJVm3sxLI6ZiT8q7s0UEaMPWY0lMyB3UonaGf0gqoVd7Jfj+e0XHbilwWsK/0uws4bP0Slhw==", new RongIMClient.ConnectCallback() {

                    @Override
                    public void onTokenIncorrect() {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Toast.makeText(StartActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                        RongIM.getInstance().startPrivateChat(StartActivity.this, "7943", "title");
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {
                        Log.d("MainActivity", errorCode.toString());
                    }
                });
            }
        });
    }
}
