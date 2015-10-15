package in.imates.rediodemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class RedioMain extends ActionBarActivity {

    private RadioGroup fort;
    private RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redio_main);

        fort = (RadioGroup) findViewById(R.id.rediogrp);
        Button btn = (Button) findViewById(R.id.info);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selid = fort.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(selid);
                String fortname = (String) rb.getText();

                Toast.makeText(getApplicationContext(),fortname,Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.putExtra("name",fortname);
                intent.setClass(RedioMain.this, FortInfo.class);
                startActivity(intent);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_redio_main, menu);
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
