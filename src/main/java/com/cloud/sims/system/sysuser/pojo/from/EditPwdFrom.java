package com.cloud.sims.system.sysuser.pojo.from;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditPwdFrom {
    private String id;
    private String oldPwd;
    private String newPwd;
    private String newTwoPwd;
}
