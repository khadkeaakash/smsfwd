package com.king.eknumber.smsfwd;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.content.BroadcastReceiver;
import android.widget.EditText;
import android.widget.*;

import java.util.jar.Attributes;

import static com.king.eknumber.smsfwd.R.id.editText;


public class MainActivity extends AppCompatActivity {


    private int activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Message sms = new Message(getApplicationContext().getContentResolver());
    String smstext;
    int i=0,j=0;

    //public interface SMSListener
    //{
    //    public void messageReceived(String messageText);
    //}

    public void onClickReadSms ( View view)
    {
        //Intent intent = new Intent(this, )
       // smstext = sms.getMessageUnread();
        Log.i("I","onClickReadSms");
    Message sms = new Message();
    String DisplaySMS = sms.ReadSMS(getIntent());
    TextView displaytext = (TextView)findViewById(R.id.textView);
    displaytext.setText(DisplaySMS);
    }

    public void SendToWhatsapp( View view)
    {

    }
}
