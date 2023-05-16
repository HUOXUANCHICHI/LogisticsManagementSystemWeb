package dao.impl;

import dao.VehicleDao;
import dbc.DBConnection;
import model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2023/05/15/17:07
 */
public class VehicleDaoImpl implements VehicleDao {

    DBConnection dbc = new DBConnection();
    Connection connection = dbc.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    boolean flag = false;

    @Override
    public List<Vehicle> selectVehicle() throws Exception {
        String sql = "SELECT * FROM Logiman_Sysdb.dbo.Vehicle";
        ps = connection.prepareStatement(sql);
        List<Vehicle> vehicleList = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("vehicleId"));
                vehicle.setCarNumber(rs.getString("carNumber"));
                vehicle.setDescription(rs.getString("description"));
                vehicleList.add(vehicle);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return vehicleList;
    }

    @Override
    public boolean insertVehicle(Vehicle vehicle) throws Exception {
        try {
            String sql = "INSERT INTO Logiman_Sysdb.dbo.Vehicle VALUES (?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, vehicle.getVehicleId());
            ps.setString(2, vehicle.getCarNumber());
            ps.setString(3, vehicle.getDescription());
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
    public boolean updateVehicle(Vehicle vehicle) throws Exception {
        try {
            String sql = "UPDATE Logiman_Sysdb.dbo.Vehicle SET carNumber = ?, description = ? WHERE vehicleId = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, vehicle.getCarNumber());
            ps.setString(2, vehicle.getDescription());
            ps.setInt(3, vehicle.getVehicleId());
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
    public boolean deleteVehicle(int vehicleId) throws Exception {
        try {
            String sql = "DELETE FROM Logiman_Sysdb.dbo.Vehicle WHERE vehicleId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, vehicleId);
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
