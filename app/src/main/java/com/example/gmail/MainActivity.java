package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemModel>  items;
    EditText search;
    Button favorite;
    boolean clickButton;
    EmailItemAdapter adapter;
    RecyclerView recyclerView;

    public boolean changeStatusButton(boolean button){
        return  !button;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        items.add(new ItemModel("FACEBOOK", "we are going to go out with my uncle, oke oke oke", "Please contact me again", "9:00 PM"));
        items.add(new ItemModel("CTT", "Sometimes just like this, may be you need to go out if you are stress", "Please contact me again", "6:00 PM"));
        items.add(new ItemModel("YOUTUBE", "Mixigaming has a new video", "Please contact me again", "9:00 AM"));
        items.add(new ItemModel("24H", "There are news that you may be interested", "Please contact me again", "9:50 PM"));
        items.add(new ItemModel("AONE", "we are going to go out to shopping", "Please contact me again", "19:40 PM"));
        items.add(new ItemModel("CODEFORCES", "Come on, you should finish our contest in week", "Please contact me again", "11:20 PM"));
        items.add(new ItemModel("PDF", "You need to photo this paper", "Please contact me again", "7:00 PM"));
        items.add(new ItemModel("WORD", "You have a new homework with word 365. Pleas install office 365 and do it", "Please contact me again", "8:00 PM"));
        items.add(new ItemModel("EXCEL", "Download the Exise ", "Please contact me again", "5:00 PM"));
        items.add(new ItemModel("FACEBOOK", "we are going to go out with my uncle, oke oke oke", "Please contact me again", "9:00 PM"));
        items.add(new ItemModel("CTT", "we are going to go out with my uncle, oke oke oke", "Please contact me again", "6:00 PM"));
        items.add(new ItemModel("YOUTUBE", "we are going to go out with my uncle, oke oke oke", "Please contact me again", "9:00 AM"));
        items.add(new ItemModel("24H", "we are going to go out with my uncle, oke oke oke", "Please contact me again", "9:50 PM"));
        items.add(new ItemModel("AONE", "we are going to go out with my uncle, oke oke oke", "Please contact me again", "19:40 PM"));
        items.add(new ItemModel("CODEFORCES", "we are going to go out with my uncle, oke oke oke", "Please contact me again", "11:20 PM"));

//        ItemAdapter adapter = new ItemAdapter(items);
//        ListView listView = findViewById(R.id.listView);
//        listView.setAdapter(adapter);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new EmailItemAdapter(items);
        recyclerView.setAdapter(adapter);

        search = (EditText) findViewById(R.id.search);
        favorite = (Button) findViewById(R.id.button);

        // process when click the button Favorite
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickButton == false){
                    adapter = new EmailItemAdapter(ItemDao.getListFavorite(items));
                    recyclerView.setAdapter(adapter);
                }
                else {
                    adapter = new EmailItemAdapter(items);
                    recyclerView.setAdapter(adapter);
                }
                clickButton=changeStatusButton(clickButton);
            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }

        });

    }

    private void filter(String s)
    {
        if (s==null || s.length()<3){
            adapter = new EmailItemAdapter(items);
            recyclerView.setAdapter(adapter);

        }
        else{
            adapter = new EmailItemAdapter(ItemDao.getListSearch(items, (String) s));
            recyclerView.setAdapter(adapter);
        }
    }
}
