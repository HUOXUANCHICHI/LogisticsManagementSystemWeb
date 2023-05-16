package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogisticsCenter implements Serializable {
    private static final long serialVersionUID = 1L;
    private int logisticsCenterId;
    private String logisticsCenName;
    private String logisticsCenAdd;

}
