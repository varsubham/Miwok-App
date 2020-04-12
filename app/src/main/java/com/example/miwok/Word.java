package com.example.miwok;

public class Word {

    private String english_translation;
    private String miwok_translation;
    private int img;
    private int mp3;

    public String get_miwok_translation(){
        return miwok_translation;
    }

    public String get_english_translation(){
        return english_translation;
    }

    public int getImg(){
        return img;
    }

    public int get_mp3(){
        return mp3;
    }

    public Word(String english, String miwok, int img, int mp3){
        this.english_translation = english;
        this.miwok_translation = miwok;
        this.mp3 = mp3;
        this.img = img;
    }

    public Word(String english, String miwok, int mp3){
        this.english_translation = english;
        this.miwok_translation = miwok;
        this.mp3 = mp3;
    }
}
