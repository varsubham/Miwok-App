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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Word> {

    MediaPlayer mp3;
    public CustomAdapter(Context context, ArrayList<Word> al){
        super(context, 0, al);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView =convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.number_list_item_layout,parent, false);
        }
        final Word current_word = getItem(position);

        TextView english_word = listItemView.findViewById(R.id.textview1);
        english_word.setText(current_word.get_english_translation());

        TextView mivok_words = listItemView.findViewById(R.id.textview2);
        mivok_words.setText(current_word.get_miwok_translation());

        ImageView img = listItemView.findViewById(R.id.imageview1);
        int temp = current_word.getImg();
        if(temp != 0) {
            img.setImageResource(current_word.getImg());
        }
        final MediaPlayer.OnCompletionListener mlistner = new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                releaseMediaPlayer();
            }
        };
        final ImageView img2 = listItemView.findViewById(R.id.imageview_blue_2);
        img2.setImageResource(R.drawable.number_list_rect);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();
                mp3 = MediaPlayer.create(getContext(), current_word.get_mp3());
                mp3.start();
                mp3.setOnCompletionListener(mlistner);
                Animation au = AnimationUtils.loadAnimation(getContext(), R.anim.increase_alpha);
                img2.startAnimation(au);

            }
        });
        return listItemView;
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp3 != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp3.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp3 = null;
        }
    }


}
