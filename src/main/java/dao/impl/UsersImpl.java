package dao.impl;

import dao.UsersDao;
import dbc.DBConnection;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersImpl implements UsersDao {
    DBConnection dbc = new DBConnection();
    Connection connection = dbc.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    boolean flag = false;

    @Override
    public boolean login(Users users) throws Exception {
        try {
            String sql = "SELECT * FROM Users WHERE username = ? AND userPwd = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getUserPwd());
            rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
                users.setUsername(users.getUsername());
                users.setUserPwd(users.getUserPwd());
                users.setUserContact(users.getUserContact());
                rs.close();
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return flag;
    }

    @Override
    public Users selectUsersByName(String usersname) throws Exception {
        try {
            String sql = "SELECT * FROM Users WHERE username = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, usersname);
            rs = ps.executeQuery();
            Users users = new Users();
            if (rs.next()) {
                flag = true;
                users.setUserId(users.getUserId());
                users.setUsername(users.getUsername());
                users.setUserPwd(users.getUserPwd());
                users.setUserContact(users.getUserContact());
                rs.close();
                ps.close();
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return null;
    }
    @Override
    public List<Users> selectUsers() throws Exception {
        String sql = "SELECT * FROM Users";
        ps = connection.prepareStatement(sql);
        List<Users> Users = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Users users = new Users();
                users.setUserId(rs.getInt("userId"));
                users.setUsername(rs.getString("username"));
                users.setUserPwd(rs.getString("userPwd"));
                users.setUserContact(rs.getString("userContact"));
                Users.add(users);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return Users;
    }

    @Override
    public boolean insertUsers(Users users) throws Exception {
        try {
            String sql = "INSERT INTO Users VALUES (?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getUserPwd());
            ps.setString(3, users.getUserContact());
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
    public boolean updateUsers(Users users) throws Exception {
        try {
            String sql = "UPDATE Users SET username = ?, userPwd = ?, userContact = ? WHERE userId = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getUserPwd());
            ps.setString(3, users.getUserContact());
            ps.setInt(4, users.getUserId());
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
    public boolean deleteUsers(int userId) throws Exception {
        try {
            String sql = "DELETE FROM Users WHERE userId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
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
