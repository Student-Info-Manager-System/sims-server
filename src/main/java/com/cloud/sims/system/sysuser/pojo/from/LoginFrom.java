package com.cloud.sims.system.sysuser.pojo.from;

import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * @author Long
 */
@Data
public class LoginFrom {
    @NotBlank(message = "账户不能为空")
    private String account;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "登录选项不能为空")
    private String type;
}
