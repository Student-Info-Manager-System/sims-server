package com.cloud.sims.common.constant;

/**
 * @author Long
 */
public interface ErrorMsg {
    String PWD_NOT_EQ = "两次密码不一致";

    String CHECK_DATA = "请检查数据完整";

    String MAJOR_CODE_NOT_NULL = "专业代码不能为空";

    String MAJOR_NAME_NOT_NULL = "专业名称不能为空";

    String DATA_NOT_FOLL = "信息不充分";

    String STUDENT_NUMBER_HAS = "学号一已存在";

    String NAME_HAS = "名称已存在";

    String NUMBER_HAS = "编号已存在";

    String LOGIN_USER_FIND_FAIL = "未登录或登录身份过期";

    String NOT_FOUNT = "信息未完善";

    String DATA_WRITE_OUT_ERROR = "数据写出异常";

    String A_DATA_WRITE_BOOK_ERROR = "一条数据写出异常";

    String URL_INVALID = "链接失效，请重新获取";

    String URL_MADE_ERROR = "链接生成失败！请联系管理员处理。";

    String USER_INFO_MUST_NOT_NULL = "账号或密码不能为空";

    String USER_INFO_NOT_SUCCESS = "账号或密码有误";

    String ACCOUNT_NOT_FOUND = "该账号不存在";

    String ACCOUNT_IDENTITY_ERROR = "禁止操作";

    String SYSTEM_ERROR = "系统异常";

    String USERNAME_IS_EXISTENCE = "用户名已存在";

    String PHONE_FORMAT_ERROR = "手机号格式有误";

    String EMAIL_FORMAT_ERROR = "邮箱格式有误";
}
