package com.spring.mitra.url_shortener.model;

import java.util.List;
import java.util.Random;

import com.spring.mitra.url_shortener.UrlSingleton;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="URLS")
public class Url {
    @Id
    @Column(name = "SHORT_URL")
    private String short_url;
    @Column(name = "ORIG_URL")
    private String orig_url;
    public String getShort_url() {
        return short_url;
    }
    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }
    public String getOrig_url() {
        return orig_url;
    }
    public void setOrig_url(String orig_url) {
        this.orig_url = orig_url;
    }
    public Url shorten(){
        UrlSingleton instance = UrlSingleton.getInstance();
        String temp = "";
        Random rand = new Random();
        List<Character> base64 = instance.getBase64();
        for(int i=0; i<instance.getMX_LEN(); i++){
            temp = temp + base64.get(rand.nextInt(base64.size()));
        }
        this.setShort_url(temp);
        return this;
    }
}
