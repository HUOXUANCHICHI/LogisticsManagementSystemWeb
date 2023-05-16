package dao;

import model.Warehouse;

import java.util.List;

public interface WarehouseDao {
    List<Warehouse> warehouseSelect() throws Exception;

    boolean insertWarehouse(Warehouse warehouse) throws Exception;

    boolean updateWarehouse(Warehouse warehouse) throws Exception;

    boolean deleteWarehouse(int warehouseId) throws Exception;

    int getIdByName(String productsName) throws Exception;
}
