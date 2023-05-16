package dao.impl;

import dao.LogisticsCenterDao;
import dbc.DBConnection;
import model.LogisticsCenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogisticsCenterImpl implements LogisticsCenterDao {
    DBConnection dbc = new DBConnection();
    Connection connection = dbc.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    boolean flag = false;

    @Override
    public List<LogisticsCenter> selectLogisticsCenter() throws Exception {
        String sql = "SELECT * FROM LogisticsCenter";
        ps = connection.prepareStatement(sql);
        List<LogisticsCenter> LogisticsCenter = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                LogisticsCenter logisticsCenter = new LogisticsCenter();
                logisticsCenter.setLogisticsCenterId(rs.getInt("logisticsCenterId"));
                logisticsCenter.setLogisticsCenName(rs.getString("logisticsCenName"));
                logisticsCenter.setLogisticsCenAdd(rs.getString("logisticsCenAdd"));
                LogisticsCenter.add(logisticsCenter);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return LogisticsCenter;
    }

    @Override
    public boolean insertLogisticsCenter(LogisticsCenter logisticsCenter) throws Exception {
        try {
            String sql = "INSERT INTO LogisticsCenter VALUES (?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, logisticsCenter.getLogisticsCenterId());
            ps.setString(2, logisticsCenter.getLogisticsCenName());
            ps.setString(3, logisticsCenter.getLogisticsCenAdd());
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
    public boolean updateLogisticsCenter(LogisticsCenter logisticsCenter) throws Exception {
        try {
            String sql = "UPDATE LogisticsCenter SET logisticsCenName = ?, logisticsCenAdd = ? WHERE logisticsCenterId = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, logisticsCenter.getLogisticsCenName());
            ps.setString(2, logisticsCenter.getLogisticsCenAdd());
            ps.setInt(3, logisticsCenter.getLogisticsCenterId());
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
    public boolean deleteLogisticsCenter(int logisticsCenterId) throws Exception {
        try {
            String sql = "DELETE FROM LogisticsCenter WHERE logisticsCenterId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, logisticsCenterId);
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
