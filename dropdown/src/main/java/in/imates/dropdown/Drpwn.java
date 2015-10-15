package in.imates.dropdown;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;


public class Drpwn extends Activity {

    private String[] states;
    private Spinner sp;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drpwn);

        iv = (ImageView) findViewById(R.id.flag);
        sp = (Spinner) findViewById(R.id.spinner1);
        states = getResources().getStringArray(R.array.countries_list);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(Drpwn.this, android.R.layout.simple_spinner_item, states);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

                switch (pos) {

                    case 0:
                        iv.setImageResource(R.drawable.australia);
                        break;
                    case 1:
                        iv.setImageResource(R.drawable.bangladesh);
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.bhutan);
                        break;
                    case 3:
                        iv.setImageResource(R.drawable.england);
                        break;
                    case 4:
                        iv.setImageResource(R.drawable.india);
                        break;
                    case 5:
                        iv.setImageResource(R.drawable.nepal);
                        break;
                    case 6:
                        iv.setImageResource(R.drawable.usa);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drpwn, menu);
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
