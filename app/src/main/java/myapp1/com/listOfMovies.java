package myapp1.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class listOfMovies extends ArrayAdapter<String> {


    public listOfMovies(Context context, String[] names) {
        super(context, R.layout.list_of_movies, names);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater josesInflater = LayoutInflater.from(getContext());
        View customView = josesInflater.inflate(R.layout.list_of_movies, parent, false);

        String singleItems = getItem(position);
        TextView josesText = (TextView) customView.findViewById(R.id.josesTextView);
        ImageView josesImage = (ImageView) customView.findViewById(R.id.josesImageView);

        josesText.setText(singleItems);
        josesImage.setImageResource(R.mipmap.luis);

        return customView;

    }
}
