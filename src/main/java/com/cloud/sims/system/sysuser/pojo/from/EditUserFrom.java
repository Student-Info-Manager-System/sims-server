package com.cloud.sims.system.sysuser.pojo.from;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Long
 */
@Data
public class EditUserFrom {

    private String avatar;
    @NotBlank(message = "账户不能为空")
    private String username;
    @NotBlank(message = "性别不能为空")
    private String sex;
    @NotBlank(message = "住址不能为空")
    private String address;
    private String email;
    private String phone;
    private String birthDay;
}
