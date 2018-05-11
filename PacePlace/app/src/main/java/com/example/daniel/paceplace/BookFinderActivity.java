package com.example.daniel.paceplace;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class BookFinderActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {



    ListView listView;
    BookListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_finder_listview);


        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Web Development", "E.F.Codd"));
        bookList.add(new Book("Basics of Networking", "Joseph Benjamin"));
        bookList.add(new Book("Data Structures", "Markus Testotic"));
        bookList.add(new Book("Programming Concepts", "Daniel Peterson"));
        bookList.add(new Book("Machine Learning", "Carl Maxben"));
        bookList.add(new Book("DataBase programming", "Geoge Assendo"));

        adapter = new BookListAdapter(this, bookList);
        listView = findViewById(R.id.BookList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        assert searchManager != null;
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);


        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return true;
    }
}
