package softeng.eventplanning;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import API.SettingsAPI;


public class userPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);




    }
    public void updateUserPage(String[] info){
        TextView editTextPlace;

        editTextPlace = (TextView) findViewById(R.id.userBday);
        editTextPlace.setText(info[0]);
        editTextPlace = (TextView) findViewById(R.id.userFname);
        editTextPlace.setText(info[1]);
        editTextPlace = (TextView) findViewById(R.id.userLname);
        editTextPlace.setText(info[2]);
        editTextPlace = (TextView) findViewById(R.id.userBio);
        editTextPlace.setText(info[3]);
        editTextPlace = (TextView) findViewById(R.id.userPhone);
        editTextPlace.setText(info[4]);
        editTextPlace = (TextView) findViewById(R.id.userUsername);
        editTextPlace.setText(info[5]);
    }


}