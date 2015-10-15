package in.imates.arithmaticopp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ArithMain extends ActionBarActivity {

    private EditText num1,num2;
    private RadioGroup rg;
    private Button btnresult;
    private RadioButton rb;
    private TextView result;
    int rslt;String rsl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arith_main);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        btnresult = (Button) findViewById(R.id.check);
        result = (TextView) findViewById(R.id.result);

        btnresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int nu1 = Integer.parseInt(num1.getText().toString());
                int nu2 = Integer.parseInt(num2.getText().toString());

                int selid = rg.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(selid);
                String val = (String) rb.getText();

                switch (val){

                    case "Addition":
                        rslt = nu1+nu2;
                        rsl =String.valueOf(rslt);
                        result.setText("Addition = ");
                        result.append(rsl);
                        break;
                    case "Subtraction":
                        rslt = nu1-nu2;
                        rsl =String.valueOf(rslt);
                        result.setText("Subtraction = ");
                        result.append(rsl);
                        break;
                    case "Multiplication":
                        rslt = nu1*nu2;
                        rsl =String.valueOf(rslt);
                        result.setText("Multiplication = ");
                        result.append(rsl);
                        break;
                    case "Division":
                        float   nu = Float.parseFloat(num1.getText().toString());
                        float nuu = Float.parseFloat(num2.getText().toString());
                        float  rslt = nu/nuu;
                        rsl =String.valueOf(rslt);
                        result.setText("Division = ");
                        result.append(rsl);
                        break;
                    default:
                         Toast.makeText(getApplicationContext(),"Make Some Choice",Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

    }
}