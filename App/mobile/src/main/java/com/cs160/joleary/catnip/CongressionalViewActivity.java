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
        import android.widget.ImageView;


/**
 * Created by IlakyaWork on 3/3/2016.
 */
public class CongressionalViewActivity extends Activity {

    private Button senator_one_button;
    private Button senator_two_button;
    private Button hr_one_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congressional);

        senator_one_button = (Button) findViewById(R.id.senator_1_info);
        senator_two_button = (Button) findViewById(R.id.senator_2_info);
        hr_one_button = (Button) findViewById(R.id.hr_1_info);

        senator_one_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(getBaseContext(), SenatorOneActivity.class);
                startActivity(sendIntent);
            }
        });

        senator_two_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(getBaseContext(), SenatorTwoActivity.class);
                startActivity(sendIntent);
            }
        });

        hr_one_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(getBaseContext(), HROneActivity.class);
                startActivity(sendIntent);
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


