package in.imates.databaseop;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button save,view;
    private EditText name,sname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button) findViewById(R.id.save);
        view = (Button) findViewById(R.id.view);
        name = (EditText) findViewById(R.id.name);
        sname = (EditText) findViewById(R.id.sname);

        save.setOnClickListener(this);
        view.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.save:
                boolean flag = true;
                try {
                    String fn = name.getText().toString();
                    String sn = sname.getText().toString();

                    Operations op = new Operations(MainActivity.this);
                    op.open();
                    op.create(fn, sn);
                    op.close();
                }catch (Exception e){
                        flag = false;

                }finally {
                    if(flag){
                        Dialog d = new Dialog(this);
                        d.setTitle("Success.....");
                        TextView tv = new TextView(this);
                        tv.setText("khkdhfkjsfk");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;

            case R.id.view:

                startActivity(new Intent(MainActivity.this, in.imates.databaseop.view.class));
                break;

        }
    }
}
