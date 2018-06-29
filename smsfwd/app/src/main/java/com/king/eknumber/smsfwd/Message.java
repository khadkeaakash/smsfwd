package com.king.eknumber.smsfwd;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build;
import android.provider.Telephony;
import android.provider.Telephony.Sms;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;


public class Message extends BroadcastReceiver
{

public static final String SMS_BUNDLE = "pdus";



@Override
public void onReceive(Context context, Intent intent)
{
    Bundle bundle = intent.getExtras();

    if(intent.getAction().equalsIgnoreCase("android.provider.Telephony.SMS_RECEIVED"))
    {
        if(bundle !=null)
        {
          Object[] sms = (Object[]) bundle.get(SMS_BUNDLE);
          String smsMsg = "";
          String smsSender = "";

            SmsMessage smsMessage;
            Object format = null;
            for (int i = 0; i< sms.length; i++)
            {
                smsMessage = SmsMessage.createFromPdu((byte[])sms[i],"3gpp");

                smsMsg = smsMessage.getDisplayMessageBody().toString();
                smsSender = smsMessage.getDisplayOriginatingAddress();

                smsMsg+= "SMS from: " + smsMessage.getDisplayOriginatingAddress() + "\n" + smsMessage.getDisplayMessageBody().toString();
            }

            //TextView displaytext = (TextView)findViewById(R.id.textView);
            //displaytext.setText(smsMsg);
        }
    }

}


public String ReadSMS(Intent intent)
    {
        Log.i("I","Message.java.ReadSms");
        String smsMsg = "";
        Bundle bundle = intent.getExtras();

        //if(intent.getAction().equalsIgnoreCase("android.provider.Telephony.SMS_RECEIVED"))
       // {
            if(bundle !=null)
            {
                Log.i("I","bundle!=NUll");
                Object[] sms = (Object[]) bundle.get(SMS_BUNDLE);
                String smsSender = "";

                SmsMessage smsMessage;

                for (int i = 0; i< sms.length; i++)
                {
                    String format = bundle.getString("format");
                    smsMessage = SmsMessage.createFromPdu((byte[])sms[i],format);
                /*
                smsMsg = smsMessage.getDisplayMessageBody().toString();
                smsSender = smsMessage.getDisplayOriginatingAddress();
                */
                    smsMsg+= "SMS from: " + smsMessage.getDisplayOriginatingAddress() + "\n" + smsMessage.getDisplayMessageBody().toString();
                    Log.d("D",smsMsg );
                }


            }
       // }
    return smsMsg;
    }


}