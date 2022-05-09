package com.github.sumitdas28.restservicesapp.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.github.sumitdas28.restservicesapp.model.DynamicFilterVO;
import com.github.sumitdas28.restservicesapp.model.StaticFilterVO;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dynamic")
public class DynamicFilterController {

    @GetMapping("/filter")
    public MappingJacksonValue getFiltering(){
        var filterBean = new DynamicFilterVO("value11","value12","value13");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(filterBean);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/filter-list")
    public MappingJacksonValue getFilteringList(){
        var filterBeanList =  Arrays.asList(new DynamicFilterVO("value11","value12","value13"),
                new DynamicFilterVO("value21","value22","value23"));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(filterBeanList);
        mapping.setFilters(filters);
        return mapping;
    }
}
