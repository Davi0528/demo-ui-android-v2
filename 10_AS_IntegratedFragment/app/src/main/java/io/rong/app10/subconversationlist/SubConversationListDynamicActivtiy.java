package io.rong.app10.subconversationlist;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import io.rong.app10.R;
import io.rong.app10.activity.BaseActivtiy;
import io.rong.imkit.fragment.SubConversationListFragment;

/**
 * Created by Bob on 15/7/28.
 * 聚合会话列表动态集成
 */
public class SubConversationListDynamicActivtiy extends BaseActivtiy{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rong_activity);

        SubConversationListFragment fragment = new SubConversationListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //xxx 为你要加载的 id
        transaction.add(R.id.rong_content, fragment);
        transaction.commit();
    }
}
