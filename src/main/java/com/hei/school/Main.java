package com.hei.school;

import com.hei.school.model.Category;
import com.hei.school.model.Product;
import com.hei.school.service.Dataretriever;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Dataretriever d = new Dataretriever();
        Main m = new Main();

        //getAllCategory
        System.out.println("============ALL CATEGORY============");
        m.testGetAllCategories(d);

        //getProductList
        System.out.println("============GET PRODUCT LIST============");
        m.testGetProductList(d, 1, 10);
        m.testGetProductList(d, 1, 5);
        m.testGetProductList(d, 1, 3);
        m.testGetProductList(d, 2, 2);


    }

    public void testGetAllCategories(Dataretriever d) throws SQLException {
        List<Category> c = d.getAllCategories();
        c.forEach(System.out::println);
        System.out.println();
    }
    public void testGetProductList(Dataretriever d, int page, int size) throws SQLException {
        List<Product> p = d.getProductList(page, size);
        p.forEach(System.out::println);
        System.out.println();
    }
}