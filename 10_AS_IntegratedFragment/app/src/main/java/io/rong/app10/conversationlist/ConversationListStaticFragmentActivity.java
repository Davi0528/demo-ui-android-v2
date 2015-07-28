package io.rong.app10.conversationlist;

import android.os.Bundle;

import io.rong.app10.activity.BaseActivtiy;
import io.rong.app10.R;

/**
 * Created by Bob on 15/7/28.
 * 会话列表静态集成 fragment
 */
public class ConversationListStaticFragmentActivity extends BaseActivtiy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversationlist_static_fr);
    }
}
