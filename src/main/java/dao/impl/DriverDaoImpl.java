package dao.impl;

import dao.DriverDao;
import dbc.DBConnection;
import model.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2023/05/15/13:37
 */
public class DriverDaoImpl implements DriverDao {

    DBConnection dbc = new DBConnection();
    Connection connection = dbc.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    boolean flag = false;

    @Override
    public List<Driver> selectDriver() throws Exception {
        String sql = "SELECT * FROM Logiman_Sysdb.dbo.Driver";
        ps = connection.prepareStatement(sql);
        List<Driver> driversList = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Driver driver = new Driver();
                driver.setDriverId(rs.getInt("driverId"));
                driver.setDriverName(rs.getString("driverName"));
                driver.setTelephone(rs.getString("telephone"));
                driver.setDriverAddress(rs.getString("driverAddress"));
                driversList.add(driver);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return driversList;
    }

    @Override
    public boolean insertDriver(Driver driver) throws Exception {
        try {
            String sql = "INSERT INTO Logiman_Sysdb.dbo.Driver VALUES (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, driver.getDriverId());
            ps.setString(2, driver.getDriverName());
            ps.setString(3, driver.getTelephone());
            ps.setString(4, driver.getDriverAddress());
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
    public boolean updateDriver(Driver driver) throws Exception {
        try {
            String sql = "UPDATE Logiman_Sysdb.dbo.Driver SET driverName = ?, telephone = ?, driverAddress = ? WHERE driverId = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, driver.getDriverName());
            ps.setString(2, driver.getTelephone());
            ps.setString(3, driver.getDriverAddress());
            ps.setInt(4, driver.getDriverId());
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
    public boolean deleteDriver(int driverId) throws Exception {
        try {
            String sql = "DELETE FROM Logiman_Sysdb.dbo.Driver WHERE driverId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, driverId);
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
}
