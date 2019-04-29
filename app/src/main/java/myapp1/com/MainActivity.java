package myapp1.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /* Toast Method*/
    public void toastMsg(String msg){
        // creating messages for ech button
        Toast b = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        b.show();
        Toast c = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        c.show();
        Toast d = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        d.show();
    }

    /* Method that call buttons messages*/
    public void displayToastMsgB(View view){
        toastMsg("Do you want to play a game?");
    }
    public void displayToastMsgC(View view){
        toastMsg("My first Application");
    }
    public void displayToastMsgD(View view){
        toastMsg("Everything goes well so far.");
    }

    /* Called when the User taps the send button*/
    public void sendMessage(View view){
        // Do something in response to the button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void displayMovies(View view) {
        Intent intent = new Intent(this, DisplayMoviesActivity.class);
        startActivity(intent);
    }
}
