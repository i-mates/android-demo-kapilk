package in.imates.fetch_imates;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends Activity {

    private String[] status;
    private Spinner sp;
    String myJSON;
    private ProgressDialog pDialog;

    private static final String TAG_RESULTS="result";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_CON ="contact";

    JSONArray starray = null;

    ArrayList<HashMap<String, String>> studentlist;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = (Spinner) findViewById(R.id.spstatus);
        status = getResources().getStringArray(R.array.status_list);
        list = (ListView) findViewById(R.id.lvinfo);
        studentlist = new ArrayList<HashMap<String,String>>();
        Log.e("hdkfjdhgk","lkjlkjflh");


        ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, status);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String st = sp.getItemAtPosition(position).toString();
           //     Toast.makeText(getApplicationContext(),st,Toast.LENGTH_LONG).show();

                if(position >0) {
                    getData(st);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });

    }

    public void getData(final String st){
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                pDialog = new ProgressDialog(MainActivity.this);
                pDialog.setMessage("Fetching Data....");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(true);
                pDialog.show();
            }

            @Override
            protected String doInBackground(String... params) {
                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();


                nameValuePairs.add(new BasicNameValuePair("status",st));

                InputStream inputStream = null;
                String result = null;
                try
                {

                    Log.e("pass 3", "connection success ");
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://kapil1992.16mb.com/fetch-data.php");
                   // httppost.setHeader("Content-type", "application/json");
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    inputStream = entity.getContent();
                    Log.e("pass 1", "connection success ");
                }
                catch(Exception e)
                {
                    Log.e("Fail 1", e.toString());
                //    Toast.makeText(getApplicationContext(), "Invalid IP Address",
                         //   Toast.LENGTH_LONG).show();
                }

                try
                {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();
                    Log.e("pass 5", "Testing ");


                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) {
                    // Oops
                }
                finally {
                    try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
                }
                Log.e("pass 6",result);

                return result;
            }

            @Override
            protected void onPostExecute(String result) {
           //     Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                myJSON = result;
                pDialog.dismiss();
                showList();
            }
        }

    //    Toast.makeText(getApplicationContext(),"testing1",Toast.LENGTH_LONG).show();

        GetDataJSON g = new GetDataJSON();
        g.execute(st);

        }

    protected void showList(){
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            starray = jsonObj.getJSONArray(TAG_RESULTS);
            studentlist.clear();
            for(int i=0;i<starray.length();i++){
                JSONObject c = starray.getJSONObject(i);
                String id = c.getString(TAG_ID);
                String name = c.getString(TAG_NAME);
                String address = c.getString(TAG_CON);

                HashMap<String,String> stu = new HashMap<String,String>();

                stu.put(TAG_ID, id);
                stu.put(TAG_NAME, name);
                stu.put(TAG_CON, address);
                studentlist.add(stu);
            }

            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, studentlist, R.layout.list_item,
                    new String[]{TAG_ID,TAG_NAME,TAG_CON},
                    new int[]{R.id.id, R.id.name, R.id.contact}
            );
            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

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
