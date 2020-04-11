package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {


    ArrayList<WordFamily> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Family Members");
        tb.setTitleTextColor(Color.parseColor("#FFFFFF"));
        tb.setTitleMarginStart(80);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_button);

        get_words();

        CustomAdapterFamily customAdapterFamily = new CustomAdapterFamily(this, words);

        ListView lv = findViewById(R.id.list_view);
        lv.setAdapter(customAdapterFamily);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void get_words()
    {
        words.add(new WordFamily("father", "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new WordFamily("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new WordFamily("son", "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new WordFamily("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new WordFamily("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new WordFamily("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new WordFamily("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new WordFamily("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new WordFamily("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new WordFamily("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

    }
}
