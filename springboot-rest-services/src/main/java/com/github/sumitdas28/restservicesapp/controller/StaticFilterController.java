package com.github.sumitdas28.restservicesapp.controller;

import com.github.sumitdas28.restservicesapp.model.StaticFilterVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/static")
public class StaticFilterController {

    @GetMapping("/filter")
    public StaticFilterVO getFiltering(){
        return new StaticFilterVO("value11","value12","value13");
    }

    @GetMapping("/filter-list")
    public List<StaticFilterVO> getFilteringList(){
        return Arrays.asList(new StaticFilterVO("value11","value12","value13"),
                new StaticFilterVO("value21","value22","value23"));
    }
}
