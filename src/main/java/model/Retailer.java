package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Retailer implements Serializable {
    private static final long serialVersionUID = 1L;
    private int retailerId;
    private String retName;
    private String retAdd;
    private String retCon;
    private int productsId;
    private String productsName;


}
