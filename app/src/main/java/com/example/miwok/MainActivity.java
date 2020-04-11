package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation au, au2, au3, au4, au5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Miwok");
        tb.setTitleTextColor(Color.parseColor("#FFFFFF"));
        tb.setTitleMarginStart(80);
        tb.setLogo(R.mipmap.ic_launcher_icon_main_page);

        //loading imageview for different tabs
        final ImageView color_tab = findViewById(R.id.imageView3);
        final ImageView family_tab = findViewById(R.id.imageView6);
        final ImageView phrase_tab = findViewById(R.id.imageView5);
        final ImageView number_tab = findViewById(R.id.imageView);


        //Setting animation on these
        ImageView background = findViewById(R.id.imageView4);
        ImageView center_rect = findViewById(R.id.imageView7);
        ImageView center_logo = findViewById(R.id.imageView8);
        TextView miwok_text = findViewById(R.id.app_title);


        au4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.from_top_to_bottom);
        au4.setStartOffset((long)200);
        au4.setDuration((long)500);
        background.startAnimation(au4);

        au = AnimationUtils.loadAnimation(MainActivity.this, R.anim.from_top_to_bottom);
        au.setStartOffset((long)700);
        au.setDuration((long)400);
        center_rect.startAnimation(au);

        au2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.from_top_to_bottom);
        au2.setStartOffset((long)1000);
        au2.setDuration(300);
        center_logo.startAnimation(au2);

        au3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.from_top_to_bottom);
        au3.setStartOffset((long)1200);
        au3.setDuration((long)200);
        miwok_text.startAnimation(au3);

        au5 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.increase_alpha2);
        au5.setStartOffset((long)400);
        au5.setDuration(1300);
        tb.startAnimation(au5);


        //onclick method to load different activity accordingly
        color_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color_tab.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.increase_alpha));
                startActivity(new Intent(MainActivity.this, ColorsActivity.class));
            }
        });

        family_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                family_tab.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.increase_alpha));
                startActivity(new Intent(MainActivity.this, FamilyActivity.class));
            }
        });

        phrase_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phrase_tab.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.increase_alpha));
                startActivity(new Intent(MainActivity.this, PhrasesActivity.class));
            }
        });

        number_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_tab.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.increase_alpha));
                startActivity(new Intent(MainActivity.this, NumbersActivity.class));
            }
        });
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
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                return true;
            }
            return super.onOptionsItemSelected(menu);
        }
}
