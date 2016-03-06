package com.cs160.joleary.catnip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            Intent sendIntent = new Intent(getBaseContext(), RepresentativeActivity.class);
            sendIntent.putExtra("LOCATION", extras.getString("LOCATION"));
            startActivity(sendIntent);

            //String catName = extras.getString("CAT_NAME");
            //mFeedBtn.setText("Feed " + catName);
        }

    }
}
