package in.imates.i_mates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by root on 26/9/15.
 */
public class Third extends Activity {

    private TextView tv1,tv2,tv3;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        tv1 = (TextView) findViewById(R.id.uname1);
        tv2 = (TextView) findViewById(R.id.pswd1);
        tv3 = (TextView) findViewById(R.id.cpswd1);

        btn2 = (Button) findViewById(R.id.proceed1);

        Bundle b =getIntent().getExtras();

        String uname = b.getString("uname");
        String pswd = b.getString("pswd");
        String cpswd = b.getString("cpswd");

        tv1.setText(uname);
        tv2.setText(pswd);
        tv3.setText(cpswd);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Third.this,Forth.class));

            }
        });


    }
}
