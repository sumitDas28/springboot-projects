package com.github.sumitdas28.restservicesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @GetMapping("/welcome")
    public String helloWorld(){
        return messageSource.getMessage("welcome", null, LocaleContextHolder.getLocale());
    }
}
