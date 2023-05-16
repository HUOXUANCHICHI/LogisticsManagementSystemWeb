package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String username;
    private String userPwd;
    private String userContact;
/*    private String accountIsStop;
    private String accountRole;*/
}
