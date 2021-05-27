package sg.edu.rp.c346.s19024292.c302_p06_sakilaclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ViewFilmsActivity extends AppCompatActivity {
    TextView tvCat;
    ListView lv;
    ArrayList<Film> al = new ArrayList<Film>();
    ArrayAdapter aa;
    Category data;

    ArrayList<Category> alCategories = new ArrayList<Category>();
    ArrayAdapter<Category> aaCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_films);
        tvCat = findViewById(R.id.tvCat);
        Intent i = getIntent();
        data = (Category) i.getSerializableExtra("data");
        tvCat.setText(data.getName());
        lv = findViewById(R.id.lvFilm);
        aa = new FilmAdapter(ViewFilmsActivity.this, R.layout.film_list, al);
        lv.setAdapter(aa);


        RequestParams params = new RequestParams();
        params.put("id", data.getId());

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.0.2.2/C302_sakila/getFilmsByCategoryId.php",params, new JsonHttpResponseHandler(){
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){
                try{
                    for( int i=0; i<response.length(); i++){
                        JSONObject category = (JSONObject)response.get(i);

                        Film f = new Film(category.getString("title"), category.getInt("release_year"), category.getString("rating"));

                        al.add(f);
                    }
                } catch (JSONException e){

                }
                aa.notifyDataSetChanged();
            }
        });

    }
}
