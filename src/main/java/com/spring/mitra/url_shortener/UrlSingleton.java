package com.spring.mitra.url_shortener;

import java.util.ArrayList;
import java.util.List;

public class UrlSingleton {
    private static UrlSingleton instance;
    private List<Character> base64 = new ArrayList<>();
    private int MX_LEN; 
    public List<Character> getBase64() {
        return base64;
    }
    public void setBase64(List<Character> base64) {
        this.base64 = base64;
    }
    public int getMX_LEN() {
        return MX_LEN;
    }
    public void setMX_LEN(int mX_LEN) {
        MX_LEN = mX_LEN;
    }
    private UrlSingleton(){
        this.MX_LEN = 8;
        for(char ch='0';ch<='9';ch++)base64.add(ch);
        for(char ch='A';ch<='Z';ch++)base64.add(ch);
        for(char ch='a';ch<='z';ch++)base64.add(ch);
        base64.add('/');
        base64.add('+');
    }
    public static UrlSingleton getInstance(){
        if(instance == null){
            instance = new UrlSingleton();
        }
        return instance;
    }
}
