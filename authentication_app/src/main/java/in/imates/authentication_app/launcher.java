package in.imates.authentication_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by root on 28/11/15.
 */
public class launcher extends Activity {

    private static final String APP_SHARED_PREFS = "asdasd_preferences";
    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    private boolean isusergeneratekey;
    private boolean isuserregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPrefs = getApplicationContext().getSharedPreferences(APP_SHARED_PREFS, Context.MODE_PRIVATE);
        isusergeneratekey = sharedPrefs.getBoolean("userkeystate", false);
        isuserregister = sharedPrefs.getBoolean("userregstate", false);

        if(isusergeneratekey == false){
            startActivity(new Intent(launcher.this,MainActivity.class));
        }
        else if(isuserregister == true){
            startActivity(new Intent(launcher.this,Register.class));
        }
        else {
            startActivity(new Intent(launcher.this,Welcome.class));

        }
    }
}
