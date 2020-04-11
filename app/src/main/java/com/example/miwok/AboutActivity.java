package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.graphics.Color;
import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        // Adding custom toolbar, and changing some properties

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("About");
        tb.setTitleTextColor(Color.parseColor("#FFFFFF"));
        tb.setTitleMarginStart(80);
        tb.setLogo(R.drawable.ic_about_white);

        // We are display the back button on the toolbar

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_button);
    }
    // To call when back button is pressed
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
