package in.imates.sqlite_auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.sql.SQLException;

import static android.content.SharedPreferences.Editor;


public class MainActivity extends Activity {

    String str1,str2;
String con;
    public EditText et_name,et_contact;
    public Button b_reg,b_send;
    public TextView tv_message,tv_key;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.editname);
        et_contact = (EditText) findViewById(R.id.editcontact);
        tv_message = (TextView) findViewById(R.id.tvmessage);
        tv_key = (TextView) findViewById(R.id.tvkey);
        b_reg = (Button) findViewById(R.id.breg);
        b_send = (Button) findViewById(R.id.bsend);

     //   sharedPrefs = getApplicationContext().getSharedPreferences(APP_SHARED_PREFS, Context.MODE_PRIVATE);

        b_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String  nme = et_name.getText().toString();
               con = et_contact.getText().toString();
                String combine = (nme + con);
                str1 = encrypt(combine);
                str2 = encrypt(str1);
                Toast.makeText(getApplicationContext(),"kjhgkjdf",Toast.LENGTH_LONG).show();
                boolean fl = true;
                try {
                    Operations op = new Operations(MainActivity.this);
                    op.open();
                    op.create(nme, con, str1, str2);
                    op.close();

                } catch (SQLException e) {
                    fl = false;
                    e.printStackTrace();
                } finally {
                    if (fl) {
                        Dialog d = new Dialog(MainActivity.this);
                        d.setTitle("Success.....");
                        TextView tv = new TextView(MainActivity.this);
                        tv.setText("khkdhfkjsfk");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                tv_message.setText("Send The Following Key To Admin For Authentication");
                tv_key.setText(str1);
            }
        });

        b_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clientencr1 = tv_key.getText().toString();
                String Adminencr2 = encrypt(clientencr1);

         //       editor = sharedPrefs.edit();
          //      editor.putBoolean("userkeystate", true);
          //      editor.commit();


          //      Intent smsIntent = new Intent(Intent.ACTION_VIEW);
          //      smsIntent.setType("vnd.android-dir/mms-sms");
         //       smsIntent.putExtra("address", "9011213998");
          //      smsIntent.putExtra("sms_body", clientencr1);
          //      startActivity(smsIntent);
         //       Toast.makeText(MainActivity.this,
           //             "Sending SMS..\n\nKEY:\n" + clientencr1,Toast.LENGTH_LONG).show();


               Intent intent= new Intent();
                intent.putExtra("adminkey", Adminencr2);
                intent.putExtra("contact", con);

                intent.setClass(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

    }


    public String encrypt(String combine){

        try
        {
            // Create MD5 Hash

            MessageDigest digest = MessageDigest.getInstance("MD5");

            digest.update(combine.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
            {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
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
