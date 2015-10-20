package in.imates.databaseop;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by root on 19/10/15.
 */
public class view extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);

        TextView tv = (TextView) findViewById(R.id.sqlinfo);
        Operations info = new Operations(this);
        try {
            info.open();
            String data = info.getData();
            info.close();
            tv.setText(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
