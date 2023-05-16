package dao;

import model.Manufacturer;

import java.util.List;

public interface ManufacturerDao {
    List<Manufacturer> selectManufacturer() throws Exception;

    boolean insertManufacturer(Manufacturer manufacturer) throws Exception;

    boolean updateManufacturer(Manufacturer manufacturer) throws Exception;

    boolean deleteManufacturer(int manufacturerId) throws Exception;

    int getIdByName(String productsName) throws Exception;
}
