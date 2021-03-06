package softeng.eventplanning;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ExpandableListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import API.LogInAPI;


public class MainActivity extends AppCompatActivity {

    HashMap<String, List<String>> Friends;
    List<String> Friend_list;
    ExpandableListView exp_list;
    friendadapter adapter2;
    String[] mobileArray = {"Event 1            Distance:","Event 2            Distance:","Event 3            Distance:","Event 4            Distance:","Event 5            Distance:","Event 6            Distance:","Event 7            Distance:","Event 8            Distance:"};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_page);
        final String[] create_user_info = new String[3];
        final EditText username_input = (EditText) findViewById(R.id.edit_username);
        final EditText password = (EditText) findViewById(R.id.edit_password);
        Button b = (Button) findViewById(R.id.login_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LogInAPI asyncT = createAsyncTask();
                asyncT.setsomething(create_user_info);
                if(asyncT.getStatus() != AsyncTask.Status.RUNNING) {
                    //Log.d("CALLED", "yup");
                    String user_password = password.getText().toString();
                    String username = username_input.getText().toString();
                    create_user_info[0] = username;
                    create_user_info[1] = user_password;
                    Log.d("myTag", Arrays.toString(create_user_info));
                    asyncT.execute();
                }

            }


        });
        getSupportActionBar().hide();

    }
    private LogInAPI createAsyncTask(){
        LogInAPI api = new LogInAPI();
        api.signupActivity(this);
        return api;
    }
    public void createEventClicked(MenuItem item){
        Intent createEventChange = new Intent(this,createEvent.class);
        startActivity(createEventChange);
    }

    public void logoutClicked(MenuItem item){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void addFriendClicked(MenuItem item){
        Intent intent = new Intent(this, addFriend.class);
        startActivity(intent);
    }
    public void setupTabsView(View v) {
        getSupportActionBar().show();
        Intent tabViewChange = new Intent(this, tabView.class);
        startActivity(tabViewChange);
    }
    public void accountSettingsCLicked(MenuItem item) {
        Intent accountSettings = new Intent(this, userPage.class);
        accountSettings.putExtra("Username",LoggedInUser.username);
        startActivity(accountSettings);
    }
    public void createAccount(View v){
        Intent intent = new Intent(this, CreateNewUser.class);
        startActivity(intent);
    }
    //Menu
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

}


