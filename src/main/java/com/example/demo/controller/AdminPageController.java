package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {


    @GetMapping(value = "/admin")
    public String listCategory() {
        return "listCategory";
    }

    @GetMapping(value = "/add")
    public String add() {
        return "listCategory";
    }

    @GetMapping(value = "/admin_category_edit")
    public String editCategory() {
        return "editCategory";
    }

    @GetMapping(value = "/admin_property_list")
    public String listProperty() {
        return "listProperty";

    }

    @GetMapping(value = "/admin_property_edit")
    public String editProperty() {
        return "editProperty";

    }

    @GetMapping(value = "/admin_product_list")
    public String listProduct() {
        return "listProduct";

    }

    @GetMapping(value = "/admin_product_edit")
    public String editProduct() {
        return "editProduct";

    }

    @GetMapping(value = "/admin_productImage_list")
    public String listProductimage() {
        return "listProductImage";
    }

    @GetMapping(value = "/admin_user_list")
    public String listUser() {
        return "listUser";

    }

    @GetMapping(value = "/admin_order_list")
    public String listOrder() {
        return "listOrder";
    }

    @GetMapping(value = "/admin_propertyValue_edit")
    public String editPropertyValue() {
        return "editPropertyValue";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
}