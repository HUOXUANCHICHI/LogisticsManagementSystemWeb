package dao.impl;

import Factory.DaoFactory;
import dao.RetailerDao;
import dbc.DBConnection;
import model.Retailer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RetailerImpl implements RetailerDao {
    DBConnection dbc = new DBConnection();
    Connection connection = dbc.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    boolean flag = false;

    @Override
    public List<Retailer> selectRetailer() throws Exception {
        String sql = "SELECT R.retailerId, retName, retAdd, retCon, P.productsName\n" +
                "FROM retailer R\n" +
                "         LEFT JOIN Products P on R.productsId = P.productsId";
        ps = connection.prepareStatement(sql);
        List<Retailer> Retailer = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Retailer retailer = new Retailer();
                retailer.setRetailerId(rs.getInt("retailerId"));
                retailer.setRetName(rs.getString("retName"));
                retailer.setRetAdd(rs.getString("retAdd"));
                retailer.setRetCon(rs.getString("retCon"));
                retailer.setProductsName(rs.getString("productsName"));
                Retailer.add(retailer);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return Retailer;
    }

    @Override
    public boolean insertRetailer(Retailer retailer) throws Exception {
        int productsId = DaoFactory.retailerDaoInstance().getIdByName(retailer.getProductsName());
        try {
            String sql = "INSERT INTO Retailer VALUES (?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, retailer.getRetailerId());
            ps.setString(2, retailer.getRetName());
            ps.setString(3, retailer.getRetAdd());
            ps.setString(4, retailer.getRetCon());
            ps.setInt(5, productsId);
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
    public boolean updateRetailer(Retailer retailer) throws Exception {
        int productsId = DaoFactory.retailerDaoInstance().getIdByName(retailer.getProductsName());
        try {
            String sql = "UPDATE Retailer SET retName = ?, retAdd = ?, retCon = ?, productsId = ? WHERE retailerId = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, retailer.getRetName());
            ps.setString(2, retailer.getRetAdd());
            ps.setString(3, retailer.getRetCon());
            ps.setInt(4, productsId);
            ps.setInt(5, retailer.getRetailerId());
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
    public boolean deleteRetailer(int retailerId) throws Exception {
        try {
            String sql = "DELETE FROM Retailer WHERE retailerId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, retailerId);
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

    @Override
    public int getIdByName(String productsName) throws Exception {
        try {
            String sql = "SELECT productsId FROM Products WHERE productsName = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, productsName);
            rs = ps.executeQuery();
            if (rs.next()) {
                int productsId = rs.getInt("productsId");
                return productsId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return 0;
    }
}
