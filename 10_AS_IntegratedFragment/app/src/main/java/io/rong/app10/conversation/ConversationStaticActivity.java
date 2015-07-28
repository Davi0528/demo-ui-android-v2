package io.rong.app10.conversation;

import android.net.Uri;
import android.os.Bundle;

import io.rong.app10.App;
import io.rong.app10.activity.BaseActivtiy;
import io.rong.app10.R;
import io.rong.imkit.fragment.ConversationFragment;

/**
 * Created by Bob on 15/7/14.
 * activity 静态集成
 */
public class ConversationStaticActivity extends BaseActivtiy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.conversation);

        ConversationFragment fragment =  (ConversationFragment)getSupportFragmentManager().findFragmentById(R.id.conversation);

        Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                .appendPath("conversation").appendPath(io.rong.imlib.model.Conversation.ConversationType.PRIVATE.getName().toLowerCase())
                .appendQueryParameter("targetId", App.mTargetID).appendQueryParameter("title", "hello").build();

        fragment.setUri(uri);
    }


}
