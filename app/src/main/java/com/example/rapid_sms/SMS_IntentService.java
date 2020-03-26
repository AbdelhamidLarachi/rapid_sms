package com.example.rapid_sms;

import android.app.IntentService;
import android.content.Intent;

import java.util.regex.*;
import android.telephony.SmsManager;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


public class SMS_IntentService extends IntentService {

    FirebaseDatabase database;
    DatabaseReference db;

    // DECLARE PATTERN
    String regex = "^(00213|\\+213|0)(5|6|7)[0-9]{8}$";
    // COMPILE PATTERN
    Pattern p = Pattern.compile(regex);


    public SMS_IntentService() {
        super("SMS_IntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent){

    database = FirebaseDatabase.getInstance();
    db = database.getReference("info");

    // GET INFO
    getInfo();

    }



    public void getInfo() {

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String msg = dataSnapshot.child("msg").getValue(String.class);
                String tel = dataSnapshot.child("tel").getValue(String.class);

                // SEND SMS
                sendSMS(msg, tel);

            }

            @Override
            public void onCancelled(DatabaseError error) {

                // THROW ERROR
                Log.v("FireSMS", "Failed to read value.", error.toException());
            }
        });
    }



    public void sendSMS(String msg, String tel){
        Matcher m = p.matcher(tel);

        // (PATTERN DO MATCH)
        if(m.find() && m.group().equals(tel)) {        // IF (REGEX)
            if(tel.charAt(0)==0 && tel.charAt(1)!=0)
                tel.replaceFirst("0", "+213");

            // SEND SMS
            SmsManager mySmsManager = SmsManager.getDefault();
            mySmsManager.sendTextMessage(tel,null, msg, null, null);

        }

    }

}
