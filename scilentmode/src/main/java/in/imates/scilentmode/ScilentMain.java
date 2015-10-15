package in.imates.scilentmode;

import android.media.AudioManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;


public class ScilentMain extends ActionBarActivity {

    private AudioManager am;
    private ToggleButton tb;
    private boolean ringer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scilent_main);

        am = (AudioManager) getSystemService(AUDIO_SERVICE);

         tb = (ToggleButton) findViewById(R.id.sci1);

        int rengermode = am.getRingerMode();
        if(rengermode == am.RINGER_MODE_SILENT){
            ringer = true;
            tb.setChecked(true);

        }else{
            ringer = false;
        }
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ringer == true){
                    am.setRingerMode(am.RINGER_MODE_NORMAL);
                    ringer = false;
                }
                else{
                    am.setRingerMode(am.RINGER_MODE_SILENT);
                    ringer = true;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scilent_main, menu);
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
