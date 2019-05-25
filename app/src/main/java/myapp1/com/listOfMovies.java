package myapp1.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class listOfMovies extends ArrayAdapter<String[]> {

    private final Context context;
    private final String[][] movies;



    public listOfMovies(Context context, String[][] movies) {
        super(context, R.layout.list_of_movies, movies);
        this.context = context;
        this.movies = movies;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater josesInflater = LayoutInflater.from(getContext());
        View customView = josesInflater.inflate(R.layout.list_of_movies, parent, false);
        String[] movie = getItem(position);
        TextView movieTitle = (TextView) customView.findViewById(R.id.movieTitle);
        movieTitle.setText(movies[position][0]);
        TextView movieYear = (TextView) customView.findViewById(R.id.movieYear);
        movieYear.setText(movies[position][1]);
        ImageView movieImage = (ImageView) customView.findViewById(R.id.movieImage);

        Picasso p = Picasso.get();
        p.setIndicatorsEnabled(true);
        p.setLoggingEnabled(true);
        p.load(movies[position][3]).into(movieImage);


        return customView;

    }
}
