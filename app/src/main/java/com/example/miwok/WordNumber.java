package com.example.miwok;



public class WordNumber {

    private String english_translation;
    private String miwok_translation;
    private int img;
    private int mp3;

    public int get_mp3(){

        return mp3;
    }

    public int get_image_view_id(){
        return img;
    }

    public String get_english_translation(){
        return english_translation;
    }

    public String get_miwok_translation(){
        return miwok_translation;
    }
    // Constructor which will be called in NumbersActivity Class
    public WordNumber(String english, String miwok, int image_id, int mp3){
        this.english_translation = english;
        this.miwok_translation = miwok;
        this.img = image_id;
        this.mp3 = mp3;
    }
}
