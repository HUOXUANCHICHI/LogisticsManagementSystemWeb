package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: ablaze
 * @Date: 2023/05/14/21:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer driverId;
    private String driverName;
    private String telephone;
    private String driverAddress;
}
