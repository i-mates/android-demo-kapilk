package in.imates.listmod;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListMain extends Activity {

    private ListView lv;
    ArrayAdapter <String> ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main);

        lv = (ListView) findViewById(R.id.list1);


         ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.cont));

        lv.setAdapter(ad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                int itempos =pos;

                String values[] = new String[]{"One","Two","Three","Four","Five"};
                if(itempos%2 == 0){

                    ad = new ArrayAdapter<String>(ListMain.this,android.R.layout.simple_list_item_1,
                            values);
                    lv.setAdapter(ad);

                }
                else {

                    Toast.makeText(getApplicationContext(),"Good Bye",Toast.LENGTH_LONG).show();
                }


            }
        });
    }


}
