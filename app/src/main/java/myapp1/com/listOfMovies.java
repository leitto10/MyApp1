package myapp1.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

        //String singleItems = getItem(position);
        TextView movieTitle = (TextView) customView.findViewById(R.id.movieTitle);
        movieTitle.setText(movies[position][0]);
        TextView movieYear = (TextView) customView.findViewById(R.id.movieYear);
        movieYear.setText(movies[position][1]);
        //TextView josesText = (TextView) customView.findViewById(R.id.movieTitle);
        //ImageView josesImage = (ImageView) customView.findViewById(R.id.josesImageView);

        //josesText.setText(singleItems);
        //josesImage.setImageResource(R.mipmap.luis);

        return customView;

    }
}
