package com.imis.frame.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {
    //主键ID
    @TableId("ID")
    private String id;
    //数据状态：0为删除，1为正常
    @TableLogic
    private String status;
    //数据权限过滤预留字段
    private String org;
    //数据权限过滤预留字段
    private String orgTree;
    //创建人
    private String created;
    //创建日期
    private String createDate;
    //创建时间
    private String createTime;
    //修改人
    private String updated;
    //修改日期
    private String updateDate;
    //修改时间
    private String updateTime;

}
