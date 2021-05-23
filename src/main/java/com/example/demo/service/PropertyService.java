package com.example.demo.service;

import com.example.demo.dao.PropertyDAO;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Property;
import com.example.demo.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PropertyDAO propertyDAO;
    @Autowired
    CategoryService categoryService;

    public void add(Property bean){
        propertyDAO.save(bean);
    }

    public void delete(int id){
        propertyDAO.deleteById(id);
    }

    public Property get(int id){
        return  propertyDAO.findById(id).orElse(null);
    }

    public void update(Property bean){
        propertyDAO.save(bean);
    }

    public Page4Navigator<Property> list(int cid,int start,int size,int navigatePages){
        Category category =categoryService.get(cid);
        Sort sort =Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(start,size,Sort.Direction.DESC,"id");

        Page<Property> pageFromJPA =propertyDAO.findByCategory(category,pageable);
        return  new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public List<Property> listByCategory(Category category) {
        return propertyDAO.findByCategory(category);
    }
}
