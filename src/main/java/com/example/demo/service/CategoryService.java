package com.example.demo.service;


import com.example.demo.util.Page4Navigator;
import com.example.demo.dao.CategoryDAO;
import com.example.demo.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService  {

    @Autowired
    CategoryDAO categoryDAO;

    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable= PageRequest.of(start,size,Sort.Direction.DESC,"id");
        Page pageFromJPA =categoryDAO.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public List<Category> list(){
        Sort sort =Sort.by(Sort.Direction.DESC,"id");
        return categoryDAO.findAll(sort);
    }

    public void add(Category bean){
        categoryDAO.save(bean);
    }
    public void delete(int id) {
        categoryDAO.deleteById(id);
    }
    public Category get(int id) {
        Category c= categoryDAO.findById(id).orElse(null);
        return c;
    }
    public void update(Category bean) {
        categoryDAO.save(bean);
    }
}
