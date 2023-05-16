package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;
    private int warehouseId;
    private String wareName;
    private String wareAdd;
    private int productsId;
    private String productsName;

}
