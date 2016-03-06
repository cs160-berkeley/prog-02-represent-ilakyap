package com.cs160.joleary.catnip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {
    //there's not much interesting happening. when the buttons are pressed, they start
    //the PhoneToWatchService with the cat name passed in.

    private Button letsGoButton;
    private CheckBox currentLocationChecked;
    private EditText zipCode;
    static boolean zip = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        letsGoButton = (Button) findViewById(R.id.lets_go);
        zipCode = (EditText)findViewById(R.id.current_zip);
        currentLocationChecked = (CheckBox) findViewById(R.id.current_location);

        currentLocationChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    zip = false;
                }
            }
        });

        letsGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent2 = new Intent(getBaseContext(), PhoneToWatchService.class);

                if (zip == false) {
                    sendIntent2.putExtra("LOCATION", "95384");
                    startService(sendIntent2);

                    Intent sendIntent = new Intent(getBaseContext(), CongressionalViewActivity.class);
                    startActivity(sendIntent);
                }
                else {
                    sendIntent2.putExtra("LOCATION", zipCode.getText().toString());
                    startService(sendIntent2);

                    Intent sendIntent = new Intent(getBaseContext(), CongressionalViewActivity.class);
                    startActivity(sendIntent);
                }
            }
        });

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
