package in.imates.rediodemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by root on 29/9/15.
 */
public class FortInfo  extends Activity{

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fortinfo);

        tv = (TextView) findViewById(R.id.infofort);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());

        Bundle b = getIntent().getExtras();

        String name = b.getString("name");

        if(name.equals("Raigad")){

            try {
                InputStream is = getResources().getAssets().open("raigad.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String newline = br.readLine();
                if(newline != null){

                    tv.append(newline);
                    tv.append("\n");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        if(name.equals("Sinhagad")){

            try {
                InputStream is = getResources().getAssets().open("sinhgad.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String newline = br.readLine();
                if(newline != null){

                    tv.append(newline);
                    tv.append("\n");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
