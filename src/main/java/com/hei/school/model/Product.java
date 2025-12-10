package com.hei.school.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Product {
    private  int id;
    private  String name;
    private  double price;
    private  Instant creationDatetime;
    private List<Category> category = new ArrayList<>();

    public Product(int id, String name, double price, Instant creationDatetime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.creationDatetime = creationDatetime;
    }

    public void addCategory(Category c) {
        this.category.add(c);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Instant getCreation_datetime() {
        return creationDatetime;
    }

    public void setCreation_datetime(Instant creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    public List<Category> getCategory() {
        return category;
    }

    public String getCategoryName() {
        return category.isEmpty() ? "" : category.getFirst().getName();
    }

    @Override
    public String toString() {
        String categoryName = category
                .stream()
                .map(Category::getName)
                .collect(Collectors.joining(", "));
        return String.format("Product { id = %d, name = %s, price = %.2f, creation_datetime = %s, categories=[%s] }", id, name, price, creationDatetime, categoryName);
    }
}
