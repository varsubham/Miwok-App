package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity{
    // Array List of type WordNumber(custom class), containing english, miwok and image id
    ArrayList<WordNumber> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        //Adding custom toolbar with some properties
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Numbers");
        tb.setTitleTextColor(Color.parseColor("#FFFFFF"));
        tb.setTitleMarginStart(80);
        //Adding back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_button);


        add_words(); //WordNumber are added in ArrayList

        //creating Object of Custom Adapter Number
        CustomAdapterNumbers customAdapterNumbers = new CustomAdapterNumbers(this, words);

        //Displaying the custom made array adapter in the ListView
        final ListView listview = findViewById(R.id.list_view);

        listview.setAdapter(customAdapterNumbers);


    }

    //When back button is pressed
    @Override
    public boolean onSupportNavigateUp(){

        onBackPressed();
        return true;
    }

    //Inflating menu list
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menu){
        int menu_id = menu.getItemId();
        if(menu_id == R.id.menu_about){
            //Connecting AboutActivity with NumbersActivity
            startActivity(new Intent(NumbersActivity.this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(menu);
    }

    void add_words()
    {
        words.add(new WordNumber("one", "lutti",R.drawable.number_one, R.raw.number_one));
        words.add(new WordNumber("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new WordNumber("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new WordNumber("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new WordNumber("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new WordNumber("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new WordNumber("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new WordNumber("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new WordNumber("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new WordNumber("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));



    }
}
