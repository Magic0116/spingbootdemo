package com.example.demo.service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import com.example.demo.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;
    @Autowired
    CategoryService categoryService;

    public void add(Product bean){
        productDAO.save(bean);
    }

    public void delete(int id){
        productDAO.deleteById(id);
    }

    public Product get(int id){
        return productDAO.findById(id).orElse(null);
    }

    public void update(Product bean){
        productDAO.save(bean);
    }

    public Page4Navigator<Product> list(int cid,int start, int size, int navigatePages){
        Category category=categoryService.get(cid);
        Sort sort =Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        Page<Product> pageFromJPA =productDAO.findByCategory(category,pageable);
        return  new Page4Navigator<>(pageFromJPA,navigatePages);
    }
}
