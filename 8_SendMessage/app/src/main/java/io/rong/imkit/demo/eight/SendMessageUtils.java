package io.rong.imkit.demo.eight;

import android.content.Context;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.message.TextMessage;

/**
 * Created by zhjchen on 7/10/15.
 */

public class SendMessageUtils {

    public static void sendTextMessage(Context context){

        RongIM.getInstance().getRongIMClient().sendMessage(Conversation.ConversationType.PRIVATE, "7943", TextMessage.obtain("hello !" + System.currentTimeMillis()), "", new RongIMClient.SendMessageCallback() {

            @Override
            public void onError(Integer integer, RongIMClient.ErrorCode errorCode) {

            }

            @Override
            public void onSuccess(Integer integer) {

            }
        });
    }
}
