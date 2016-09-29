package softeng.eventplanning;
import android.content.Intent;

import android.content.Intent;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.util.Log;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.view.View;
import java.io.DataOutputStream;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TabHost;

import android.view.Window;

import org.json.JSONObject;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    HashMap<String, List<String>> Friends;
    List<String> Friend_list;
    ExpandableListView exp_list;
    friendadapter adapter2;
    String[] mobileArray = {"Event 1            Distance:","Event 2            Distance:","Event 3            Distance:","Event 4            Distance:","Event 5            Distance:","Event 6            Distance:","Event 7            Distance:","Event 8            Distance:"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_user);
        final String[] create_user_info = new String[3];
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText username_input = (EditText) findViewById(R.id.username_input);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user_email = email.getText().toString();
                String user_password = password.getText().toString();
                String username = username_input.getText().toString();
                create_user_info[0] = user_email;
                create_user_info[1] = username;
                create_user_info[2] = user_password;
                Log.d("myTag", Arrays.toString(create_user_info));

                CreateAPI asyncT = new CreateAPI();
                asyncT.setsomething(create_user_info);
                asyncT.execute();

            }




        });



    /*
        TabHost tab = (TabHost) findViewById(R.id.mainTabs);
        tab.setup();

        TabHost.TabSpec spec1 = tab.newTabSpec("Current Event");
        spec1.setIndicator("Current Event");
        spec1.setContent(R.id.layout1);
        tab.addTab(spec1);

        TabHost.TabSpec spec2 = tab.newTabSpec("Home");
        spec2.setIndicator("Home");
        spec2.setContent(R.id.layout2);
        tab.addTab(spec2);

        TabHost.TabSpec spec3 = tab.newTabSpec("Search");
        spec3.setIndicator("Search");
        spec3.setContent(R.id.layout3);
        tab.addTab(spec3);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.searchresultslist, mobileArray);
        ListView listView = (ListView) findViewById(R.id.searchresults);
        listView.setAdapter(adapter);

        exp_list = (ExpandableListView) findViewById(R.id.exp_list);
        Friends = ListData.getInfo();
        Friend_list = new ArrayList<String>(Friends.keySet());

        adapter2 = new friendadapter(this, Friends, Friend_list);
        exp_list.setAdapter(adapter2);
    */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.settings_notifications:
                // TODO go to notifications page
                Toast.makeText(getApplicationContext(),
                        "Settings Updated",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings_themes:
                // TODO go to theme page
                Toast.makeText(getApplicationContext(),
                        "Settings Updated",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void eventClicked(View view){
        // TODO open event's page when clicked
    }

    public void settingsClicked(View view){
        // TODO open settings view when clicked


    }
    public void createEventClicked(MenuItem item){
        setContentView(R.layout.create_event);
    }

    public void setLocation(View v){
        setContentView(R.layout.create_event_location);
    }

    public void setDate(View v){
        setContentView(R.layout.create_event_date);
    }

    public void setTime(View v){
        setContentView(R.layout.create_event_time);
    }

    public void back(View v){
        setContentView(R.layout.create_event);

    }


    public void searchFilter(View view)
    {
        Intent intent = new Intent(this, sFilters.class);
        startActivity(intent);
    }
    public void homePage(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}


