package model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ablaze
 * @Date: 2023/05/14/21:34
 */
@Data
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer vehicleId;
    private String carNumber;
    private String description;

}
