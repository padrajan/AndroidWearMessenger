package com.zoho.show.wear.lib;

/**
 * Created by padmanabha-1058 on 3/30/17.
 */

public interface ShowWearBridge {

    void onReceive(String message);
    void onSend(String message);
}
