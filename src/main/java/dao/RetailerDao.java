package dao;

import model.Retailer;

import java.util.List;

public interface RetailerDao {
    List<Retailer> selectRetailer() throws Exception;

    boolean insertRetailer(Retailer retailer) throws Exception;

    boolean updateRetailer(Retailer retailer) throws Exception;

    boolean deleteRetailer(int retailerId) throws Exception;

    int getIdByName(String productsName) throws Exception;
}
