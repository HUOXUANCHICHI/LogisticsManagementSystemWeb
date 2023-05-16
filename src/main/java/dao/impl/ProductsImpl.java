package dao.impl;

import dao.ProductsDao;
import dbc.DBConnection;
import model.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsImpl implements ProductsDao {
    DBConnection dbc = new DBConnection();
    Connection connection = dbc.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    boolean flag = false;

    @Override
    public List<Products> selectProducts() throws Exception {
        String sql = "SELECT * FROM Products";
        ps = connection.prepareStatement(sql);
        List<Products> Products = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Products products = new Products();
                products.setProductsId(rs.getInt("productsId"));
                products.setProductsName(rs.getString("productsName"));
                Products.add(products);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return Products;
    }

    @Override
    public boolean insertProducts(Products products) throws Exception {
        try {
            String sql = "INSERT INTO Products VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, products.getProductsId());
            ps.setString(2, products.getProductsName());
            int i = ps.executeUpdate();
            if (i > 0) {
                flag = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return flag;
    }

    @Override
    public boolean updateProducts(Products products) throws Exception {
        try {
            String sql = "UPDATE Products SET productsName = ? WHERE productsId = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, products.getProductsName());
            ps.setInt(2, products.getProductsId());
            int i = ps.executeUpdate();
            if (i > 0) {
                flag = true;
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    @Override
    public boolean deleteProducts(int productsId) throws Exception {
        try {
            String sql = "DELETE FROM Products WHERE productsId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, productsId);
            int i = ps.executeUpdate();
            if (i > 0) {
                flag = true;
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return flag;
    }
}
