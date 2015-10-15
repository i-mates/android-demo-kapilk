package in.imates.rediodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import java.util.logging.Handler;

/**
 * Created by root on 30/9/15.
 */
public class Splash extends Activity {

    private static int timeout = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


       Thread timer = new Thread() {

         public void run(){

             try {
                 sleep(timeout);
                 finish();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             finally {
                 startActivity(new Intent(Splash.this,RedioMain.class));
             }
         }
       };
        timer.start();


    }
}
