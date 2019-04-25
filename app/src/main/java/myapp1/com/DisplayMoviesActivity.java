package myapp1.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class DisplayMoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movies);

        String[] names = {"Jose", "Luis", "Yo", "Tu","Jose","Luis","Yo","Me", "tut", "mamaa","nonon","hjkldh"};
        ListAdapter myAdapter = new listOfMovies(this, names);
        ListView myView = (ListView) findViewById(R.id.listViewMovies);
        myView.setAdapter(myAdapter);

        myView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String names = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(DisplayMoviesActivity.this, names, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}
