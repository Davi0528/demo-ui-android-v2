package io.rong.app10.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import io.rong.app10.R;
import io.rong.app10.adapter.MainListAdapter;
import io.rong.app10.conversationlist.ConversationListDynamicActivtiy;
import io.rong.app10.conversationlist.ConversationListDynamicFragmentActivity;
import io.rong.app10.conversationlist.ConversationListStaticActivity;
import io.rong.app10.conversationlist.ConversationListStaticFragmentActivity;
import io.rong.imkit.RongIM;

/**
 * Created by Bob on 15/7/23.
 *开启会话列表
 */
public class StartConversationListActivity extends BaseActivtiy implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private MainListAdapter mMainListAdapter;
    AlertDialog.Builder dialog;
    String[] selects = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("开启会话列表");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.rong_actionbar_back);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        initDate();
    }

    private void initDate() {

        String[] titleNameArray = this.getResources().getStringArray(
                R.array.conversationlist_list);
        mMainListAdapter = new MainListAdapter(this, titleNameArray);
        mListView.setAdapter(mMainListAdapter);
        mMainListAdapter.notifyDataSetChanged();

        mListView.setOnItemClickListener(this);


        dialog = new AlertDialog.Builder(this);
        dialog.setTitle("选择打开哪个");
        selects = new String[]{"activity 静态集成", "activity 动态集成", "fragmet 静态集成", "fragmet 动态集成"};
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0://通过 Api 调用

                showDialog1();
                break;
            case 1://通过 Uri 调用
                showDialog2();
                break;
            case 2://通过 startActivity 调用
                showDialog3();
                break;
        }
    }

    /**
     * 通过 Api 调用
     */
    private void showDialog1() {


        dialog.setItems(selects, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (RongIM.getInstance() != null)
                    RongIM.getInstance().startConversationList(StartConversationListActivity.this);
            }
        });
        dialog.show();
    }

    /**
     * 通过 Uri 调用
     */
    private void showDialog2() {


        dialog.setItems(selects, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                        .appendPath("conversationlist").build();

                startActivity(new Intent(Intent.ACTION_VIEW, uri));

            }
        });
        dialog.show();
    }

    /**
     * 通过 startActivity 调用
     */
    private void showDialog3() {


        dialog.setItems(selects, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0://activity 静态集成
                        startActivity(new Intent(StartConversationListActivity.this, ConversationListStaticActivity.class));
                        break;
                    case 1://activity 动态集成
                        startActivity(new Intent(StartConversationListActivity.this, ConversationListDynamicActivtiy.class));
                        break;
                    case 2://fragmet 静态集成
                        startActivity(new Intent(StartConversationListActivity.this, ConversationListStaticFragmentActivity.class));
                        break;
                    case 3://fragmet 动态集成
                        startActivity(new Intent(StartConversationListActivity.this, ConversationListDynamicFragmentActivity.class));
                        break;
                }

            }
        });
        dialog.show();
    }
}
