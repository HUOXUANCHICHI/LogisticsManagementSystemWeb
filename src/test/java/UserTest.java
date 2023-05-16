import dao.DriverDao;
import dao.UsersDao;
import dao.impl.DriverDaoImpl;
import dao.impl.UsersImpl;
import model.Driver;
import model.Users;
import org.junit.Test;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2023/05/15/12:08
 */
public class UserTest {
    @Test
    public void userTest() throws Exception {

        UsersDao users = new UsersImpl();
        List<Users> users1 = users.selectUsers();
        users1.forEach(System.out::println);

    }
    @Test
    public void driverTest() throws Exception {

        DriverDao driverDao = new DriverDaoImpl();
        List<Driver> driver = driverDao.selectDriver();
        driver.forEach(System.out::println);

    }
}
