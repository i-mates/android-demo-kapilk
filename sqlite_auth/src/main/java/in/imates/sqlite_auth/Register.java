package in.imates.sqlite_auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

/**
 * Created by root on 27/11/15.
 */
public class Register extends Activity{

    public Button bproceed,binf;
    public EditText etregkey;
    TextView tv;
    String contact;
    String encr2;
     String regkey;
    int id = 1;

    private static final String APP_SHARED_PREFS = "asdasd_preferences";
    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    private boolean isusergeneratekey;
    private boolean isuserregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        sharedPrefs = getApplicationContext().getSharedPreferences(APP_SHARED_PREFS, Context.MODE_PRIVATE);

        etregkey = (EditText) findViewById(R.id.regkey);
        bproceed = (Button) findViewById(R.id.bproceed);
        tv = (TextView) findViewById(R.id.info);
        binf = (Button) findViewById(R.id.buttoninf);
        binf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Bundle b = getIntent().getExtras();
        regkey = b.getString("adminkey");
      contact  = b.getString("contact");
        etregkey.setText(regkey);
        bproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regky = etregkey.getText().toString();
           //     String regky = "80ebc9e2b50a0da8266d2bef2abd6786";

                Operations op1 = new Operations(Register.this);
                try {
                    op1.open();
                    encr2 = op1.getencr2(id);
                    op1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                if(regky.equals(encr2)){

             //       editor = sharedPrefs.edit();
              //      editor.putBoolean("userregstate", true);
              //      editor.commit();

                    startActivity(new Intent(Register.this, Welcome.class));

                }

            }
        });
    }

}
