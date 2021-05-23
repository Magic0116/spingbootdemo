package com.example.demo.controller;

import com.example.demo.pojo.Product;
import com.example.demo.pojo.PropertyValue;
import com.example.demo.service.ProductService;
import com.example.demo.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyValueController {

    @Autowired
    PropertyValueService propertyValueService;

    @Autowired
    ProductService productService;

    @GetMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> list(@PathVariable("pid") int pid){
        Product product=productService.get(pid);
        propertyValueService.init(product);
        List<PropertyValue> propertyValues=propertyValueService.list(product);
        return propertyValues;
    }
    @PutMapping("/propertyValues")
    public Object update(@RequestBody PropertyValue bean) throws Exception {
        propertyValueService.update(bean);
        return bean;
    }

}
