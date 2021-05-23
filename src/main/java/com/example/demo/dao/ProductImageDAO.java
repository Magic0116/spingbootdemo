package com.example.demo.dao;

import com.example.demo.pojo.Product;
import com.example.demo.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageDAO extends JpaRepository<ProductImage,Integer>{
   public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product, String type);

}
