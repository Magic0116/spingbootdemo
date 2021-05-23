package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
//@Document(indexName = "tmall_springboot",type = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;

    private  String name;
    private String subTitle;
    private  double originalPrice;
    private  double promotePrice;
    private int stock;
    private Date createDate;

    @Transient
    private ProductImage FirstProductImage;

    public ProductImage getFirstProductImage() {
        return FirstProductImage;
    }

    public void setFirstProductImage(ProductImage firstProductImage) {
        FirstProductImage = firstProductImage;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getPromotePrice() {
        return promotePrice;
    }

    public int getStock() {
        return stock;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setPromotePrice(double promotePrice) {
        this.promotePrice = promotePrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", originalPrice=" + originalPrice +
                ", promotePrice=" + promotePrice +
                ", stock=" + stock +
                ", createDate=" + createDate +
                '}';
    }


}
