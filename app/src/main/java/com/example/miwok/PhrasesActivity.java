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

public class PhrasesActivity extends AppCompatActivity {

    ArrayList<WordPhrases> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Phrases");
        tb.setTitleTextColor(Color.parseColor("#FFFFFF"));
        tb.setTitleMarginStart(80);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_button);

        add_words();

        CustomAdapterPhrases customAdapterPhrases = new CustomAdapterPhrases(this, words);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(customAdapterPhrases);

    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.menu_about){
            startActivity(new Intent(PhrasesActivity.this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void add_words(){

        words.add(new WordPhrases("Where are you going?","minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new WordPhrases("What is your name?","tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new WordPhrases("My name is...","oyaaset...", R.raw.phrase_my_name_is));
        words.add(new WordPhrases("How are you feeling?","michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new WordPhrases("I’m feeling good.","kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new WordPhrases("Are you coming?","әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new WordPhrases("Yes, I’m coming.","hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new WordPhrases("I’m coming.","әәnәm", R.raw.phrase_im_coming));
        words.add(new WordPhrases("Let’s go.","yoowutis", R.raw.phrase_lets_go));
        words.add(new WordPhrases("Come here.","әnni'nem", R.raw.phrase_come_here));

    }
}