package dao.impl;

import dao.GoodsDao;
import dbc.DBConnection;
import model.Goods;

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
public class GoodsDaoImpl implements GoodsDao {

    DBConnection dbc = new DBConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    boolean flag = false;

    @Override
    public List<Goods> selectGoods() throws Exception {
        String sql = "SELECT * FROM Logiman_Sysdb.dbo.Goods";
        Connection connection = dbc.getConnection();
        ps = connection.prepareStatement(sql);
        List<Goods> goodsList = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setGoodsId(rs.getInt("goodsId"));
                goods.setGoodsName(rs.getString("goodsName"));
                goods.setGoodsAddress(rs.getString("goodsAddress"));
                goods.setGoodsWeight(rs.getString("goodsWeight"));
                goods.setCarNumber(rs.getString("carNumber"));
                goods.setDriverName(rs.getString("driverName"));
                goods.setRange(rs.getString("range"));
                goods.setCustomName(rs.getString("customName"));
                goods.setState(rs.getString("state"));
                goods.setDate(rs.getString("date"));
                goodsList.add(goods);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return goodsList;
    }

    @Override
    public boolean insertGoods(Goods Goods) {
        try {
            String sql = "INSERT INTO Logiman_Sysdb.dbo.Goods VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, Goods.getGoodsId());
            ps.setString(2, Goods.getGoodsName());
            ps.setString(3, Goods.getGoodsAddress());
            ps.setString(4, Goods.getGoodsWeight());
            ps.setString(5, Goods.getCarNumber());
            ps.setString(6, Goods.getDriverName());
            ps.setString(7, Goods.getRange());
            ps.setString(8, Goods.getCustomName());
            ps.setString(9, Goods.getState());
            ps.setString(10, Goods.getDate());
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
    public boolean updateGoods(Goods Goods) {
        try {
            String sql = "UPDATE Logiman_Sysdb.dbo.Goods SET GoodsName = ?, goodsAddress = ?, goodsWeight = ?, carNumber = ?, driverName = ?, range = ?, customName= ?, state= ?, date= ? WHERE goodsId = ?";
            Connection connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, Goods.getGoodsName());
            ps.setString(2, Goods.getGoodsAddress());
            ps.setString(3, Goods.getGoodsWeight());
            ps.setString(4, Goods.getCarNumber());
            ps.setString(5, Goods.getDriverName());
            ps.setString(6, Goods.getRange());
            ps.setString(7, Goods.getCustomName());
            ps.setString(8, Goods.getState());
            ps.setString(9, Goods.getDate());
            ps.setInt(10, Goods.getGoodsId());
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
    public boolean deleteGoods(int goodsId) {
        try {
            String sql = "DELETE FROM Logiman_Sysdb.dbo.Goods WHERE goodsId = ?";
            Connection connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, goodsId);
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
    public Goods selectGoodsById(Integer goodsId) throws Exception {
        String sql = "SELECT * FROM Logiman_Sysdb.dbo.Goods where goodsId = ?";
        Connection connection = dbc.getConnection();
        ps = connection.prepareStatement(sql);
        ps.setInt(1, goodsId);
        Goods goods = new Goods();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                goods.setGoodsId(rs.getInt("goodsId"));
                goods.setGoodsName(rs.getString("goodsName"));
                goods.setGoodsAddress(rs.getString("goodsAddress"));
                goods.setGoodsWeight(rs.getString("goodsWeight"));
                goods.setCarNumber(rs.getString("carNumber"));
                goods.setDriverName(rs.getString("driverName"));
                goods.setRange(rs.getString("range"));
                goods.setCustomName(rs.getString("customName"));
                goods.setState(rs.getString("state"));
                goods.setDate(rs.getString("date"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return goods;
    }
}
