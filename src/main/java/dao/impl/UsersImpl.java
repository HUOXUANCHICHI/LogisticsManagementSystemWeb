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
            String sql = "SELECT * FROM Logiman_Sysdb.dbo.users WHERE username = ? AND userPwd = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getUserPwd());
            rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
                users.setUsername(users.getUsername());
                users.setUserPwd(users.getUserPwd());
                users.setUserContact(users.getUserContact());
                users.setAccountRole(users.getAccountRole());
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
    public Users selectUsersByNameAndPwd(String username, String password) throws Exception {
        String sql = "SELECT * FROM Logiman_Sysdb.dbo.Users WHERE username = ? AND userPwd = ?";
        ps = connection.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        rs = ps.executeQuery();
        Users users = new Users();
        try {
            while (rs.next()) {
                users.setUserId(rs.getInt("userId"));
                users.setUsername(rs.getString("username"));
                users.setUserPwd(rs.getString("userPwd"));
                users.setUserContact(rs.getString("userContact"));
                users.setAccountRole(rs.getString("accountRole"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return users;
    }

    @Override
    public Users selectUsersById(Integer id) throws Exception {
        String sql = "SELECT * FROM Logiman_Sysdb.dbo.Users WHERE userId = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        Users users = new Users();
        try {
            while (rs.next()) {
                users.setUserId(rs.getInt("userId"));
                users.setUsername(rs.getString("username"));
                users.setUserPwd(rs.getString("userPwd"));
                users.setUserContact(rs.getString("userContact"));
                users.setAccountRole(rs.getString("accountRole"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.connClose();
        }
        return users;
    }

    @Override
    public List<Users> selectUsers() throws Exception {
        String sql = "SELECT * FROM Logiman_Sysdb.dbo.Users";
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
                users.setAccountRole(rs.getString("accountRole"));
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
            String sql = "INSERT INTO Logiman_Sysdb.dbo.Users VALUES (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getUserPwd());
            ps.setString(3, users.getUserContact());
            ps.setString(4, users.getAccountRole());
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
            String sql = "UPDATE Logiman_Sysdb.dbo.Users SET username = ?, userPwd = ?, userContact = ?, accountRole = ? WHERE userId = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getUserPwd());
            ps.setString(3, users.getUserContact());
            ps.setString(4, users.getAccountRole());
            ps.setInt(5, users.getUserId());
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
            String sql = "DELETE FROM Logiman_Sysdb.dbo.Users WHERE userId = ?";
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
