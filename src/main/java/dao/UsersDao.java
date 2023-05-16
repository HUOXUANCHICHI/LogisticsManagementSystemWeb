package dao;

import model.Users;

import java.util.List;

public interface UsersDao {
    boolean login(Users users) throws Exception;

    Users selectUsersByName(String username) throws Exception;

    List<Users> selectUsers() throws Exception;

    boolean insertUsers(Users users) throws Exception;

    boolean updateUsers(Users users) throws Exception;

    boolean deleteUsers(int userId) throws Exception;
}
