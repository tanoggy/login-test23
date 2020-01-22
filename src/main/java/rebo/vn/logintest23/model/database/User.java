package rebo.vn.logintest23.model.database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_user")
@Data
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "user_email", insertable = false, nullable = false)
  private String userEmail;

  @Column(name = "user_full_name", nullable = false)
  private String userFullName;

  @Column(name = "user_phone", nullable = false)
  private String userPhone;

  @Column(name = "user_date_of_birth")
  private Date userDateOfBirth;

  @Column(name = "user_gender")
  private String userGender;

  @Column(name = "user_address")
  private String userAddress;

  @Column(name = "user_is_active", nullable = false)
  private Boolean userIsActive;

  @Column(name = "role_id", nullable = false)
  private String roleId;

  @Column(name = "user_avatar")
  private Long imageId;

  @Column(name = "user_password", nullable = false)
  private String userPassword;

  
}