package dao.impl;

import Factory.DaoFactory;
import dao.WarehouseDao;
import dbc.DBConnection;
import model.Warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseImpl implements WarehouseDao {
    DBConnection dbc = new DBConnection();
    Connection connection = dbc.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    boolean flag = false;

    @Override
    public List<Warehouse> warehouseSelect() throws Exception {
        String sql = "SELECT W.warehouseId, wareName, wareAdd, wareAdd, P.productsName\n" +
                "FROM Warehouse W\n" +
                "         LEFT JOIN Products P on W.productsId = P.productsId";
        ps = connection.prepareStatement(sql);
        List<Warehouse> Warehouse = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Warehouse warehouse = new Warehouse();
                warehouse.setWarehouseId(rs.getInt("warehouseId"));
                warehouse.setWareName(rs.getString("wareName"));
                warehouse.setWareAdd(rs.getString("wareAdd"));
                warehouse.setProductsName(rs.getString("productsName"));
                Warehouse.add(warehouse);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return Warehouse;
    }

    @Override
    public boolean insertWarehouse(Warehouse warehouse) throws Exception {
        int productsId = DaoFactory.warehouseDaoInstance().getIdByName(warehouse.getProductsName());
        try {
            String sql = "INSERT INTO Warehouse VALUES (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, warehouse.getWarehouseId());
            ps.setString(2, warehouse.getWareName());
            ps.setString(3, warehouse.getWareAdd());
            ps.setInt(4, productsId);
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
    public boolean updateWarehouse(Warehouse warehouse) throws Exception {
        int productsId = DaoFactory.warehouseDaoInstance().getIdByName(warehouse.getProductsName());
        try {
            String sql = "UPDATE Warehouse SET wareName = ?, wareAdd = ?, productsId = ? WHERE warehouseId = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, warehouse.getWareName());
            ps.setString(2, warehouse.getWareAdd());
            ps.setInt(3, productsId);
            ps.setInt(4, warehouse.getWarehouseId());
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
    public boolean deleteWarehouse(int warehouseId) throws Exception {
        try {
            String sql = "DELETE FROM Warehouse WHERE warehouseId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, warehouseId);
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
