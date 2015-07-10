package io.rong.imkit.demo.eight;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    Button mSendTxtMsgBtn;
    Button mSendImgMsgBtn;
    Button mSendVoiceMsgBtn;
    Button mSendRichTextMsgBtn;
    Button mSendLocationMsgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mSendTxtMsgBtn = (Button) findViewById(android.R.id.button1);
        mSendImgMsgBtn = (Button) findViewById(android.R.id.button2);
        mSendVoiceMsgBtn = (Button) findViewById(R.id.button3);
        mSendRichTextMsgBtn = (Button) findViewById(R.id.button4);
        mSendLocationMsgBtn = (Button) findViewById(R.id.button5);

        mSendTxtMsgBtn.setOnClickListener(this);
        mSendImgMsgBtn.setOnClickListener(this);
        mSendVoiceMsgBtn.setOnClickListener(this);
        mSendRichTextMsgBtn.setOnClickListener(this);
        mSendLocationMsgBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case android.R.id.button1:
                SendMessageUtils.sendTextMessage(this);
                break;
            case android.R.id.button2:
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            default:
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
