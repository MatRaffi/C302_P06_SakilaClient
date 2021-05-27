package sg.edu.rp.c346.s19024292.c302_p06_sakilaclient;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class searchFilmAdapter extends ArrayAdapter {
    Context context;
    ArrayList<SearchFilm> searchFilms;
    int resource;

    public searchFilmAdapter(@NonNull Context context, int resource,ArrayList<SearchFilm> searchFilms) {
        super(context, resource, searchFilms);
        this.context = context;
        this.resource = resource;
        this.searchFilms = searchFilms;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.rowsearchfilm, parent, false);



        TextView tvCat = (TextView) rowView.findViewById(R.id.tvCategory);
        TextView tvNum = (TextView) rowView.findViewById(R.id.tvNumOfFilm);


//        SearchFilm searchFilms = SearchFilm.get(position);

//        tvCat.setText(searchFilms.getTitle());
//        tvNum.setText(searchFilms.getCount() + "");
        return rowView;
    }
}
