package rebo.vn.logintest23.model.rest;


import lombok.Data;

import java.util.Date;

@Data
public class UserRest {


    private String userEmail;


    private String userFullName;


    private String userPhone;


    private Date userDateOfBirth;


    private String userGender;


    private String userAddress;


    private Boolean userIsActive;


    private String roleId;


    private Long imageId;


    private String userPassword;
}
