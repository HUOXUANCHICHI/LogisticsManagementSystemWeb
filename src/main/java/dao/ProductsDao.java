package dao;

import model.Products;

import java.util.List;

public interface ProductsDao {
    List<Products> selectProducts() throws Exception;

    boolean insertProducts(Products products) throws Exception;

    boolean updateProducts(Products products) throws Exception;

    boolean deleteProducts(int productsId) throws Exception;
}
