package dao;

import model.Driver;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2023/05/15/13:36
 */
public interface DriverDao {
    List<Driver> selectDriver() throws Exception;

    boolean insertDriver(Driver driver) throws Exception;

    boolean updateDriver(Driver driver) throws Exception;

    boolean deleteDriver(int driverId) throws Exception;
}
