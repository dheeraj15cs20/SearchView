package com.example.adc.searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
public class MainActivity extends AppCompatActivity {
    SearchView  sv;
    ListView lv;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sv= (SearchView) findViewById(R.id.sv);
        ListView lv=(ListView)findViewById(R.id.lv);
        list = new ArrayList<>();
        list.add("India");
        list.add("Pak");
        list.add("Bhutan");
        ArrayList<String> arraycountry = new ArrayList<String>();
        arraycountry.addAll(Arrays.asList(getResources().getStringArray(R.array.countries_array)));
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                arraycountry);
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(list.contains(query)) {
                    adapter.getFilter().filter(query);
                }
                else{
                        Toast.makeText(MainActivity.this,"No match found",Toast.LENGTH_LONG).show();


                    }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }
}
