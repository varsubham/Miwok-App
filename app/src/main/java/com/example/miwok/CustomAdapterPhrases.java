package com.example.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CustomAdapterPhrases extends ArrayAdapter<Word> {
    MediaPlayer mp3;
    public CustomAdapterPhrases(Context context, ArrayList<Word> al){
        super (context, 0, al);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.number_list_item_layout, parent, false);
        }

        final Word current_word = getItem(position);

        TextView english_word = listItemView.findViewById(R.id.textview1);
        english_word.setText(current_word.get_english_translation());

        TextView mivok_words = listItemView.findViewById(R.id.textview2);
        mivok_words.setText(current_word.get_miwok_translation());

        final ImageView img2 = listItemView.findViewById(R.id.imageview_blue_2);
        img2.setImageResource(R.drawable.number_list_rect);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3 = MediaPlayer.create(getContext(), current_word.get_mp3());
                mp3.start();
                Animation au = AnimationUtils.loadAnimation(getContext(), R.anim.increase_alpha);
                img2.startAnimation(au);

            }
        });
        return listItemView;

    }
}
