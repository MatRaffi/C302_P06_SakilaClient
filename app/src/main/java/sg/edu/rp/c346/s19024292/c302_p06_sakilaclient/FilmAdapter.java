package sg.edu.rp.c346.s19024292.c302_p06_sakilaclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FilmAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Film> films;
    int resource;

    public FilmAdapter(@NonNull Context context, int resource, ArrayList<Film> films) {
        super(context, resource, films);
        this.context = context;
        this.films = films;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.film_list, parent, false);


        TextView tvTitle = (TextView) rowView.findViewById(R.id.tvDescription);
        TextView tvYear = (TextView) rowView.findViewById(R.id.tvYear);
        TextView tvRating = (TextView)rowView.findViewById(R.id.tvRating);

        Film film = films.get(position);

        tvTitle.setText(film.getTitle());
        tvYear.setText(film.getYear()+ "");
        tvRating.setText(film.getRating());
        return rowView;
    }
}
