package com.pathu.wear.message;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zoho.show.wear.lib.ShowWearBridge;
import com.zoho.show.wear.lib.ShowWearMessenger;


public class MobileMessageActivity extends AppCompatActivity implements ShowWearBridge {

    Button sendButton;
    EditText sendMessage;

    ShowWearMessenger showWearMessenger = new ShowWearMessenger();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        sendButton = (Button) findViewById(R.id.sendButton);
        sendMessage = (EditText) findViewById(R.id.sendMessage);

        sendButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = sendMessage.getText().toString();
                onSend(message);
            }
        });

        showWearMessenger.init(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    // Disconnect from the data layer when the Activity stops
    @Override
    protected void onStop() {
        showWearMessenger.disconnect();
        super.onStop();
    }

    @Override
    public void onReceive(String message) {
        Toast.makeText(this, message+"cool", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSend(String message) {
        showWearMessenger.sendMessage(message);
    }

    // Unused project wizard code
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_message, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}