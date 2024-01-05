package com.spring.mitra.url_shortener.web;

import com.spring.mitra.url_shortener.model.Url;
import com.spring.mitra.url_shortener.services.Url_Service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;


@Controller
public class UrlController {
    
    private Url_Service url_service;
    
    public UrlController(Url_Service url_service) {
        this.url_service = url_service;
    }

    @RequestMapping("/")
    public String getHome() {
        return "home";
    }
    
    @RequestMapping(value = "/shorten", method=RequestMethod.POST)    
    public String postURL(@RequestBody Url entity, Model model) {
        entity.shorten();
        this.url_service.insert(entity);
        model.addAttribute("s_url", entity.getShort_url());
        return "response";
    }

    @GetMapping("/db")
    public String getMethodName(Model model) {
        Collection<Url> URLs = this.url_service.getAll();
        model.addAttribute("URLs", URLs);
        return "db";
    }

    @GetMapping("/mitra/{param}")
    public String getMethodName(@PathVariable String param, Model model) {
        String orig_url = this.url_service.get(param).getOrig_url();
        model.addAttribute("orig_url", orig_url);
        return "redirect";
    }
}
