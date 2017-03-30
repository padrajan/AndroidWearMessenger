package com.pathu.wear.message;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WatchViewStub;
import android.widget.Toast;

import com.zoho.show.wear.lib.ShowWearBridge;
import com.zoho.show.wear.lib.ShowWearMessenger;

public class WearMessageActivity extends WearableActivity implements ShowWearBridge {


    ShowWearMessenger showWearMessenger = new ShowWearMessenger();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        /*final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
              //  textView = (TextView) stub.findViewById(R.id.text);
            }
        });*/

        setAmbientEnabled();

        showWearMessenger.init(this);

        onSend("message from wear");

    }

    @Override
    protected void onStop() {
        showWearMessenger.disconnect();
        super.onStop();
    }

    @Override
    public void onReceive(String message) {
        Toast.makeText(this, message+" super", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSend(String message) {
        showWearMessenger.sendMessage(message);
    }
}
