package io.rong.app10.conversation;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import io.rong.app10.App;
import io.rong.app10.activity.BaseActivtiy;
import io.rong.app10.R;
import io.rong.imkit.fragment.ConversationFragment;

/**
 * Created by Bob on 15/7/28.
 *
 * ConversationFragment 动态集成
 */
public class ConversationDynamicActivity extends BaseActivtiy {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rong_activity);

        ConversationFragment fragment = new ConversationFragment();

        Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                .appendPath("conversation").appendPath(io.rong.imlib.model.Conversation.ConversationType.PRIVATE.getName().toLowerCase())
                .appendQueryParameter("targetId", App.mTargetID).appendQueryParameter("title", "hello").build();
        fragment.setUri(uri);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //xxx 为你要加载的 id
        transaction.add(R.id.rong_content, fragment);
        transaction.commit();
    }
}
