package com.spring.mitra.url_shortener.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mitra.url_shortener.model.Url;
import com.spring.mitra.url_shortener.repository.Url_repository;

@Service
public class Url_Service {

    @Autowired
    private Url_repository url_repository;
    
    public void insert(Url dat){
        url_repository.save(dat);
    }
    public Url get(String short_url){
        return url_repository.findById(short_url).orElse(null);
    }
    public List<Url> getAll(){
        List<Url> all_urls = new ArrayList<>();
        url_repository.findAll().forEach(all_urls::add);
        return all_urls;
    }
}
