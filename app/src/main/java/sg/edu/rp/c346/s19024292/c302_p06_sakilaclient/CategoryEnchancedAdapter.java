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

public class CategoryEnchancedAdapter extends ArrayAdapter {
    Context context;
    ArrayList<CategoryEnhanced> categories;
    int resource;
    public CategoryEnchancedAdapter(@NonNull Context context, int resource, ArrayList<CategoryEnhanced> categories) {
        super(context, resource, categories);
        this.context = context;
        this.categories = categories;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.rowenhancement, parent, false);



        TextView tvCat = (TextView) rowView.findViewById(R.id.tvCategory);
        TextView tvNum = (TextView) rowView.findViewById(R.id.tvNumOfFilm);
        if(position %2 !=0){
                tvCat.setBackgroundColor(Color.GRAY);
                tvNum.setBackgroundColor(Color.GRAY);
        }

        CategoryEnhanced category = categories.get(position);

        tvCat.setText(category.getTitle());
        tvNum.setText(category.getCount() + "");
        return rowView;
    }
}
