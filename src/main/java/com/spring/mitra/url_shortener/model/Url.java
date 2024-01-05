package com.spring.mitra.url_shortener.model;
import java.util.ArrayList;
import java.util.List;

public class Url {
    private String short_url;
    private static long counter;
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    private static List<Character> base64 = new ArrayList<>();
    private static void init(){
        counter = 0;
        for(char ch='0';ch<='9';ch++)base64.add(ch);
        for(char ch='A';ch<='Z';ch++)base64.add(ch);
        for(char ch='a';ch<='z';ch++)base64.add(ch);
        base64.add('/');
        base64.add('+');
    }
    static{
        init();
    }
    public String getShort_url() {
        return short_url;
    }
    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }
    private String orig_url;
    public String getOrig_url() {
        return orig_url;
    }
    public void setOrig_url(String orig_url) {
        this.orig_url = orig_url;
    }
    public Url shorten(){
        Url.counter += 1;
        long temp = Url.counter; String temp_str = "";
        this.id = temp;
        while(temp != 0){
            temp_str = temp_str + Url.base64.get((int)(temp%64));
            temp = temp / 64;
        }
        this.short_url = temp_str;
        return this;
    }
}
