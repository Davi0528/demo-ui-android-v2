package io.rong.app10.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import io.rong.app10.App;
import io.rong.app10.R;
import io.rong.app10.adapter.MainListAdapter;
import io.rong.app10.conversation.ConversationDynamicActivity;
import io.rong.app10.conversation.ConversationDynamicFragmentActivity;
import io.rong.app10.conversation.ConversationStaticActivity;
import io.rong.app10.conversation.ConversationStaticFragmentActivtiy;
import io.rong.imkit.RongIM;

/**
 * Created by Bob on 15/7/27.
 * 开启会话页面
 */
public class StartConversationActivity extends BaseActivtiy implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private MainListAdapter mMainListAdapter;
    AlertDialog.Builder dialog;
    String[] selects = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("开启会话页面");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.rong_actionbar_back);
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
            case 0:
                //1.通过 Api 调用
                showDialog1();
                break;
            case 1:
                //2.通过 Uri 调用， targetUserId 要与之聊天的用户 Id。
                showDialog2();
                break;
            case 2:
                //3.通过 startActivity 调用
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
                    RongIM.getInstance().startPrivateChat(StartConversationActivity.this, App.mTargetID, "title");

            }
        });
        dialog.show();
    }
    /**
     * 通过 Uri 调用， targetUserId 要与之聊天的用户 Id
     */
    private void showDialog2() {

        dialog.setItems(selects, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                        .appendPath("conversation").appendPath(io.rong.imlib.model.Conversation.ConversationType.PRIVATE.getName().toLowerCase())
                        .appendQueryParameter("targetId", App.mTargetID).appendQueryParameter("title", "hello").build();

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
                switch (i){
                    case 0://activity 静态集成
                        startActivity(new Intent(StartConversationActivity.this,ConversationStaticActivity.class));
                        break;
                    case 1://activity 动态集成
                        startActivity(new Intent(StartConversationActivity.this,ConversationDynamicActivity.class));
                        break;
                    case 2://fragmet 静态集成
                        startActivity(new Intent(StartConversationActivity.this,ConversationStaticFragmentActivtiy.class));
                        break;
                    case 3://fragmet 动态集成
                        startActivity(new Intent(StartConversationActivity.this,ConversationDynamicFragmentActivity.class));
                        break;
                }
            }
        });
        dialog.show();
    }
}
