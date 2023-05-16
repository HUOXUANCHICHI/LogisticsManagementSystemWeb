package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Manufacturer implements Serializable {
    private static final long serialVersionUID = 1L;
    private int manufacturerId;
    private String manuName;
    private String manuAdd;
    private String manuCon;
    private String productsName;
    private int productsId;
}
