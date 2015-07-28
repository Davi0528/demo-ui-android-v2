package io.rong.app10.conversation;

import android.os.Bundle;

import io.rong.app10.activity.BaseActivtiy;
import io.rong.app10.R;

/**
 * Created by Bob on 15/7/28.
 * fragmet 静态集成
 */
public class ConversationStaticFragmentActivtiy extends BaseActivtiy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.conversation_static_fr);
    }
}
