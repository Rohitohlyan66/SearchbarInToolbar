package com.example.searchbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.items, menu);

        MenuItem menuItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Here");

        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                searchView.clearFocus();
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        };

        searchView.setOnQueryTextListener(queryTextListener);
        
        return super.onCreateOptionsMenu(menu);
    }
}