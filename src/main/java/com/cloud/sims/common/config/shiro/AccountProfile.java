package com.cloud.sims.common.config.shiro;

import lombok.*;

import java.io.Serializable;

/**
 * @author Long
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountProfile implements Serializable {

    private String id;

    private String type;
}
