package dao;

import model.Users;

import java.util.List;

public interface UsersDao {
    boolean login(Users users) throws Exception;

    Users selectUsersByNameAndPwd(String username, String password) throws Exception;
    Users selectUsersById(Integer id) throws Exception;

    List<Users> selectUsers() throws Exception;

    boolean insertUsers(Users users) throws Exception;

    boolean updateUsers(Users users) throws Exception;

    boolean deleteUsers(int userId) throws Exception;
}
