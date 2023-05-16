package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productsId;
    private String productsName;

}
