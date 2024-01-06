package com.spring.mitra.url_shortener.repository;

import org.springframework.data.repository.CrudRepository;
import com.spring.mitra.url_shortener.model.Url;

public interface Url_repository extends CrudRepository<Url, String>{

    
}