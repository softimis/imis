package com.imis.project.test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imis.frame.core.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@TableName("TB_TestEntity")
@Data
public class TestEntity extends BaseEntity{

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private int sex;
    private boolean openstate;//开启状态
    private String birthday;

}
