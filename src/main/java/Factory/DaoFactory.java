package Factory;

import dao.*;
import dao.impl.*;

public class DaoFactory {
    public static LogisticsCenterDao logisticsCenterDaoInstance() {
        return new LogisticsCenterImpl();
    }

    public static ManufacturerDao manufacturerDaoInstance() {
        return new ManufacturerImpl();
    }

    public static ProductsDao productsDaoInstance() {
        return new ProductsImpl();
    }

    public static RetailerDao retailerDaoInstance() {
        return new RetailerImpl();
    }

    public static UsersDao usersDaoInstance() {
        return new UsersImpl();
    }

    public static WarehouseDao warehouseDaoInstance() {
        return new WarehouseImpl();
    }
    public static DriverDao driverDaoInstance() {
        return new DriverDaoImpl();
    }
    public static VehicleDao vehicleDaoInstance() {
        return new VehicleDaoImpl();
    }
    public static GoodsDao goodsDaoInstance() {
        return new GoodsDaoImpl();
    }
}
