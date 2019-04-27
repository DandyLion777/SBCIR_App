package com.example.smallbusinesscyberincidenceresponse;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smallbusinesscyberincidenceresponse.R;

public class sms extends Activity{
    Button btnSend;
    EditText tvMessage;
    EditText tvNumber;
    IntentFilter intentFilter;

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //display the message in the textView
            TextView inTxt = (TextView) findViewById(R.id.textMsg);
            inTxt.setText(intent.getExtras().getString("message"));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.sms);

        //intent to filter for SMS messages received
        intentFilter = new IntentFilter();
        intentFilter.addAction("SMS_RECEIVED_ACTION");

        btnSend = (Button) findViewById(R.id.btnSend);
        tvMessage = (EditText) findViewById(R.id.tvMessage);
        tvNumber = (EditText) findViewById(R.id.tvNumber);

        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myMsg = tvMessage.getText().toString();
                String theNumber = tvNumber.getText().toString();
                sendMsg(theNumber, myMsg);
            };
        });
    }

    protected void sendMsg (String theNumber, String myMsg){
        String SENT = "Message Sent";
        String DELIVERED = "Message Delivered";

        PendingIntent sentPI = PendingIntent.getBroadcast(this,0,new Intent(SENT),0);
        PendingIntent deliveredPI = PendingIntent.getBroadcast(this,0,new Intent(DELIVERED),0);

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(theNumber, null, myMsg, sentPI, deliveredPI);

    }

    @Override
    protected  void onResume(){
        //register the receiver
        registerReceiver(intentReceiver, intentFilter);
        super.onResume();
    }

    @Override
    protected  void onPause(){
        //unregister the receiver
        unregisterReceiver(intentReceiver);
        super.onPause();
    }
}