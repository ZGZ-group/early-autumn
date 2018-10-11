package com.earlyautumn.ruaiter.user.constant;

import com.earlyautumn.ruaiter.common.BaseEnum;

/**
 * 枚举test  未测试
 */
public enum UserStatus implements BaseEnum<UserStatus> {

    STUDENT(0, "学生"),
    TEACHER(1, "老师");

    private Integer status;
    private String value;

    UserStatus(Integer status, String value) {

    }

    @Override
    public String getValue() {
        return this.value;
    }
}
