package sg.edu.rp.c346.s19024292.c302_p06_sakilaclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class SearchFilmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_film);
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
