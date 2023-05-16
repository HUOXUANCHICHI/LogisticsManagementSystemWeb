package dao;

import model.LogisticsCenter;

import java.util.List;

public interface LogisticsCenterDao {
    List<LogisticsCenter> selectLogisticsCenter() throws Exception;

    boolean insertLogisticsCenter(LogisticsCenter logisticsCenter) throws Exception;

    boolean updateLogisticsCenter(LogisticsCenter logisticsCenter) throws Exception;

    boolean deleteLogisticsCenter(int logisticsCenterId) throws Exception;
}
