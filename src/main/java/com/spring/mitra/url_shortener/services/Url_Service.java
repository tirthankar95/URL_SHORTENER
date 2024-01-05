package com.spring.mitra.url_shortener.services;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.mitra.url_shortener.model.Url;
import java.util.HashMap;
import java.util.Collection;

@Service
public class Url_Service {
    private Map<String, Url> db = new HashMap<>();
    public void insert(Url dat){
        db.put(dat.getShort_url(), dat);
    }
    public Url get(String short_url){
        Url obj = null;
        try{
            obj = db.get(short_url);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return obj;
    }
    public Collection<Url> getAll(){
        return db.values();
    }
}
