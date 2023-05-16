package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: ablaze
 * @Date: 2023/05/14/21:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer goodsId;
    private String goodsName;
    private String goodsAddress;
    private String goodsWeight;
    private String range;
    private String customName;
    private String state;
    private String date;

}
