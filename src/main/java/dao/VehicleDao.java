package dao;

import model.Vehicle;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2023/05/15/13:36
 */
public interface VehicleDao {
    List<Vehicle> selectVehicle() throws Exception;

    boolean insertVehicle(Vehicle vehicle) throws Exception;

    boolean updateVehicle(Vehicle vehicle) throws Exception;

    boolean deleteVehicle(int vehicleId) throws Exception;
}
