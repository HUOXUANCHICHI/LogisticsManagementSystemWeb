package dao.impl;

import Factory.DaoFactory;
import dao.ManufacturerDao;
import dbc.DBConnection;
import model.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerImpl implements ManufacturerDao {
    DBConnection dbc = new DBConnection();
    Connection connection = dbc.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    boolean flag = false;

    @Override
    public List<Manufacturer> selectManufacturer() throws Exception {
        String sql = "SELECT M.manufacturerId, manuName, manuAdd, manuCon, P.productsName\n" +
                "FROM Manufacturer M\n" +
                "         LEFT JOIN Products P on M.productsId = P.productsId";
        ps = connection.prepareStatement(sql);
        List<Manufacturer> manufacturers = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setManufacturerId(rs.getInt("manufacturerId"));
                manufacturer.setManuName(rs.getString("manuName"));
                manufacturer.setManuAdd(rs.getString("manuAdd"));
                manufacturer.setManuCon(rs.getString("manuCon"));
                manufacturer.setProductsName(rs.getString("productsName"));
                manufacturers.add(manufacturer);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return manufacturers;
    }

    @Override
    public boolean insertManufacturer(Manufacturer manufacturer) throws Exception {
        int productsId = DaoFactory.manufacturerDaoInstance().getIdByName(manufacturer.getProductsName());
        try {
            String sql = "INSERT INTO Manufacturer VALUES (?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, manufacturer.getManufacturerId());
            ps.setString(2, manufacturer.getManuName());
            ps.setString(3, manufacturer.getManuAdd());
            ps.setString(4, manufacturer.getManuCon());
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
    public boolean updateManufacturer(Manufacturer manufacturer) throws Exception {
        int productsId = DaoFactory.manufacturerDaoInstance().getIdByName(manufacturer.getProductsName());
        try {
            String sql = "UPDATE Manufacturer SET manuName = ?, manuAdd = ?, manuCon = ?, productsId = ? WHERE manufacturerId = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, manufacturer.getManuName());
            ps.setString(2, manufacturer.getManuAdd());
            ps.setString(3, manufacturer.getManuCon());
            ps.setInt(4, productsId);
            ps.setInt(5, manufacturer.getManufacturerId());
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
    public boolean deleteManufacturer(int manufacturerId) throws Exception {
        try {
            String sql = "DELETE FROM Manufacturer WHERE manufacturerId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, manufacturerId);
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
