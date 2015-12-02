package in.imates.authentication_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by root on 27/11/15.
 */
public class Register extends Activity {

    public Button bproceed, binf;
    public EditText etregkey;
    TextView tv;
    String encr2;
    int id = 1;

    private static final String APP_SHARED_PREFS = "asdasd_preferences";
    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        sharedPrefs = getApplicationContext().getSharedPreferences(APP_SHARED_PREFS, Context.MODE_PRIVATE);

        etregkey = (EditText) findViewById(R.id.regkey);
        bproceed = (Button) findViewById(R.id.bproceed);
        tv = (TextView) findViewById(R.id.info);

        bproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regky = etregkey.getText().toString();

                Operations op1 = new Operations(Register.this);
                try {
                    op1.open();
                    encr2 = op1.getencr2(id);
                    op1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                if (regky.equals(encr2)) {

                    editor = sharedPrefs.edit();
                    editor.putBoolean("userregstate", false);
                    editor.commit();

                    startActivity(new Intent(Register.this, Welcome.class));

                }

            }
        });
    }

}
