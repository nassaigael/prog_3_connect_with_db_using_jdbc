package com.hei.school.service;

import com.hei.school.config.DBConnection;
import com.hei.school.model.Category;
import com.hei.school.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Dataretriever {
    public List<Category> getAllCategories() {
        List<Category> result = new ArrayList<>();
        String request = "select id, name from product_category order by id asc";

        try {
            DBConnection dbConnection = new DBConnection();
            PreparedStatement ps = dbConnection.getDBConnection().prepareStatement(request);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                result.add(new Category(id, name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<Product> getProductList(int page, int size) {
        List<Product> result = new ArrayList<>();
        int offset = (page - 1) * size;
        String request = "select id, name, price, creation_datetime from Product order by id limit ? offset ?";
        try {
            DBConnection dbc = new DBConnection();
            PreparedStatement ps = dbc.getDBConnection().prepareStatement(request);
            ps.setInt(1, size);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Instant creation_datetime = rs.getTimestamp("creation_datetime").toInstant();
                Product p = new Product(id, name, price, creation_datetime);
                loadCategoriesForProduct(p);
                result.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void loadCategoriesForProduct(Product product) throws SQLException {
        String request = "select id, name from Product_category where product_id = ? order by id asc";
        DBConnection dbc = new DBConnection();
        try (
                Connection connection = dbc.getDBConnection();
                PreparedStatement ps = connection.prepareStatement(request);) {
            ps.setInt(1, product.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                product.addCategory(new Category(id, name));
            }
        }
    }
}
