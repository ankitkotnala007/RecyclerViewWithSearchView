package com.example.ankit.recyclerviewwithsearchview;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    String[] c_name = {"Address","Call","Email","Fax","Web","Website ","Donald trumph","World","Linkdin","Facebook","create","pdf","Home","View"};
    int[] c_image = {R.drawable.address,R.drawable.call,R.drawable.emailhero,R.drawable.fax_contact,R.drawable.web,R.drawable.website,R.drawable.donald,R.drawable.world,R.drawable.link,R.drawable.facebook,R.drawable.create,R.drawable.pdf,R.drawable.home,R.drawable.view};

    Toolbar toolbar ;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Hero> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int count  = 0;

        for (String Name : c_name)
        {
            arrayList.add(new Hero(Name,c_image[count]));
            count ++ ;
        }

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_items,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<Hero> newList = new ArrayList<>();

        for(Hero hero : arrayList)
        {
            String name = hero.getName().toLowerCase();
            if(name.contains(newText)){
                newList.add(hero);
            }
        }
        adapter.setFilter(newList);
        return true;
    }
}
