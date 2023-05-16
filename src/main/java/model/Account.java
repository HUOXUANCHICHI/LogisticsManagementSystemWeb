package model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ablaze
 * @Date: 2023/05/14/21:33
 */
@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long AccountId;
}
