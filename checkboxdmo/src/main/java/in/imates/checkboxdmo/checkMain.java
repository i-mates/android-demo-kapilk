package in.imates.checkboxdmo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class checkMain extends Activity {

    private CheckBox kapil,bhushan,pratik,rahul;
    private Button btn;
    private TextView tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_main);

        kapil = (CheckBox) findViewById(R.id.kapil);
        bhushan = (CheckBox) findViewById(R.id.bhushan);
        pratik = (CheckBox) findViewById(R.id.pratik);
        rahul = (CheckBox) findViewById(R.id.rahul);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        btn = (Button) findViewById(R.id.chk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(kapil.isChecked()){
                    tv1.setText("Kapil is Selected \n\n");
                }
                else{
                    tv1.setText("");
                }
                if(bhushan.isChecked()){
                    tv2.setText("Bhushan is Selected\n\n");
                }
                else{
                    tv2.setText("");
                }
                if(pratik.isChecked()){
                    tv3.setText("Pratik is Selected \n\n");
                }
                else{
                    tv3.setText("");
                }
                if(rahul.isChecked()){
                    tv4.setText("Rahul is selected \n\n");
                }
                else{
                    tv4.setText("");
                }

            }
        });


    }


}
