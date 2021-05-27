package sg.edu.rp.c346.s19024292.c302_p06_sakilaclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class CategorySummaryActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<CategoryEnhanced> al;
    ArrayAdapter<CategoryEnhanced> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_summary);

        lv = findViewById(R.id.lvEnchanced);
        al = new ArrayList<CategoryEnhanced>();
        aa = new CategoryEnchancedAdapter(CategorySummaryActivity.this, R.layout.row, al);
        lv.setAdapter(aa);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.0.2.2/C302_sakila/getCategorySummary.php", new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject category = (JSONObject) response.get(i);
                        CategoryEnhanced c = new CategoryEnhanced(category.getString("category"), category.getInt("number_films"));

                        al.add(c);
                    }
                } catch (JSONException e) {

                }
                aa.notifyDataSetChanged();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.categorySummary:
                startActivity(new Intent(this, CategorySummaryActivity.class));
                return true;
            case R.id.searchFilms:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.searchRental:
                startActivity(new Intent(this, SearchFilmActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
