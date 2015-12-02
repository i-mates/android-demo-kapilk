package in.imates.databaseop;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button save,view,sqlgetinfo,sqlupdate,sqldelete;
    private EditText name,sname,sqlrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button) findViewById(R.id.save);
        view = (Button) findViewById(R.id.view);
        name = (EditText) findViewById(R.id.name);
        sname = (EditText) findViewById(R.id.sname);
        sqlrow = (EditText) findViewById(R.id.rowid);
        sqlgetinfo = (Button) findViewById(R.id.getinfo);
        sqlupdate = (Button) findViewById(R.id.bupdate);
        sqldelete = (Button) findViewById(R.id.bdelete);
        save.setOnClickListener(this);
        view.setOnClickListener(this);
        sqlgetinfo.setOnClickListener(this);
        sqlupdate.setOnClickListener(this);
        sqldelete.setOnClickListener(this);

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
            case R.id.getinfo:
                String sr = sqlrow.getText().toString();
                long l = Long.parseLong(sr);
                Operations op = new Operations(this);
                try {
                    op.open();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String retname = op.getName(l);
                String retsname = op.getSname(l);
                op.close();

                name.setText(retname);
                sname.setText(retsname);

                break;
            case R.id.bupdate:
                String ufn = name.getText().toString();
                String usn = sname.getText().toString();
                String usr = sqlrow.getText().toString();
                long ul = Long.parseLong(usr);

                Operations uop = new Operations(this);
                try {
                    uop.open();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                uop.update(ul,ufn,usn);
                uop.close();


                break;
            case R.id.bdelete:
                String usr1 = sqlrow.getText().toString();
                long ul1 = Long.parseLong(usr1);
                Operations dop = new Operations(this);
                try {
                    dop.open();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dop.delete(ul1);
                dop.close();

                break;

        }
    }
}
