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


public class ColorsActivity extends AppCompatActivity  {

    ArrayList<Word> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Colors");
        tb.setTitleTextColor(Color.parseColor("#FFFFFF"));
        tb.setTitleMarginStart(80);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_button);

        add_words();

        CustomAdapterColors customAdapterColors = new CustomAdapterColors(this, words);
        ListView lv = findViewById(R.id.list_view);
        lv.setAdapter(customAdapterColors);

    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu){
        int menu_id = menu.getItemId();
        if(menu_id == R.id.menu_about){
            startActivity(new Intent(ColorsActivity.this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(menu);
    }

    public void add_words(){
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

    }
}
