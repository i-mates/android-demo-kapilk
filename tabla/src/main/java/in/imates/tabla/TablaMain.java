package in.imates.tabla;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class TablaMain extends Activity{

    SoundPool sp;
    TextView tv1,tv2;
    int exp1,exp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_main);

        sp = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        tv1 = (TextView) findViewById(R.id.tabla1);
        tv2 = (TextView) findViewById(R.id.tabla2);
        exp1 = sp.load(this,R.raw.tab2,1);
        exp2 = sp.load(this,R.raw.tab1,1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sp.play(exp1,1,1,0,0,1);
            //    sp.
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sp.play(exp2,1,1,0,0,1);
              //  sp.
            }
        });

    }


}
