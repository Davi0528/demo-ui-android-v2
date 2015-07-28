package io.rong.app10.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import io.rong.app10.R;
import io.rong.app10.adapter.MainListAdapter;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 *
 */
public class MainActivity extends BaseActivtiy implements AdapterView.OnItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    String token = "IWb9/EypgQlMEo/W/o3qSLI6ZiT8q7s0UEaMPWY0lMyB3UonaGf0gmlCJbN+zU7OvAaDYa9d8U6xzmBRkFjv+Q==";
    private ListView mListView;
    private MainListAdapter mMainListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("MainActivity");
        mListView = (ListView) findViewById(R.id.list);
        initDate();
    }

    private void initDate() {

        String[] titleNameArray = this.getResources().getStringArray(
                R.array.main_list);
        mMainListAdapter = new MainListAdapter(this, titleNameArray);
        mListView.setAdapter(mMainListAdapter);
        mMainListAdapter.notifyDataSetChanged();

        mListView.setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                RongIM.connect(token, new RongIMClient.ConnectCallback() {
                    @Override
                    public void onTokenIncorrect() {
                        Log.e(TAG, "-----onTokenIncorrect-----");
                    }

                    @Override
                    public void onSuccess(String s) {
                        Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "-----onSuccess-----" + s);
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {
                        Log.e(TAG, "-----onError-----" + errorCode);
                    }
                });
                break;
            case 1://开启会话列表页面
               startActivity(new Intent(MainActivity.this,StartConversationListActivity.class));
                break;
            case 2://开启聚合会话页面
                startActivity(new Intent(MainActivity.this,StartSubConversationActivity.class));
                break;
            case 3://开启会话页面
                startActivity(new Intent(MainActivity.this,StartConversationActivity.class));

                break;
        }
    }
}
