package in.imates.md5_encr_decr;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.MessageDigest;


public class MainActivity extends Activity {

    Button getkey;
    EditText name,contact;
    TextView encr1,encr2;
    String name1,contact1,combine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.etname);
        contact = (EditText) findViewById(R.id.etcontact);
        encr1 = (TextView) findViewById(R.id.tvencr1);
        encr2 = (TextView) findViewById(R.id.tvencr2);
        getkey = (Button) findViewById(R.id.bgetkey);
        getkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1 = name.getText().toString();
                contact1 = contact.getText().toString();
                combine =(name1+contact1);
                Log.e("pass 1", combine);
                String str_encr1 = getMD5Encryption(combine);
                String str_encr2 = getMD5Encryption(str_encr1);
                encr1.setText(str_encr1);
                encr2.setText(str_encr2);
            }
        });
    }

    public String getMD5Encryption(String strpassword)
    {
        try
        {
            // Create MD5 Hash

            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");

            digest.update(strpassword.getBytes());
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
