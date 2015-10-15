package in.imates.i_mates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by root on 26/9/15.
 */
public class Second extends Activity{

    private TextView uname,pswd,cpswd;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        uname = (TextView) findViewById(R.id.username);
        pswd = (TextView) findViewById(R.id.pswd);
        cpswd = (TextView) findViewById(R.id.cpswd);
        btn = (Button) findViewById(R.id.btnreg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pwd = pswd.getText().toString();
                String cwd = cpswd.getText().toString();
                if(pwd.equals(cwd)){

                    Intent inte = new Intent();

                    inte.putExtra("uname",uname.getText().toString().trim());
                    inte.putExtra("pswd",pswd.getText().toString().trim());
                    inte.putExtra("cpswd",cpswd.getText().toString().trim());
                    inte.setClass(Second.this, Third.class);
                    startActivity(inte);
                }

                else{

                    Toast.makeText(getApplicationContext(),"Password And Confirm Password Dont match",Toast.LENGTH_LONG).show();
                    cpswd.setError("Confirm password don't match");
                    pswd.setText("");
                    cpswd.setText("");
                }


            }
        });

    }
}
