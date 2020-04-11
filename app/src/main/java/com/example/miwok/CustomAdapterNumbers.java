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


public class CustomAdapterNumbers extends ArrayAdapter<WordNumber> {
    MediaPlayer mp3;
    //Made a constructor
    public CustomAdapterNumbers(Context context, ArrayList<WordNumber> al){
        super(context, 0, al);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.number_list_item_layout, parent, false);
        }
        final WordNumber current_word = getItem(position);


        TextView english_word = listItemView.findViewById(R.id.textview1);
        english_word.setText(current_word.get_english_translation());

        TextView mivok_word = (TextView)listItemView.findViewById(R.id.textview2);
        mivok_word.setText(current_word.get_miwok_translation());

        ImageView img = (ImageView)listItemView.findViewById(R.id.imageview1);
        img.setImageResource(current_word.get_image_view_id());

        final ImageView img2 = (ImageView)listItemView.findViewById(R.id.imageview_blue_2);
        img2.setImageResource(R.drawable.number_list_rect);
        //img2.setAlpha(100);
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
