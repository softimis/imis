package com.imis.frame.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

public class BaseEntity implements Serializable {
    //主键ID
    @TableId("ID")
    private String id;
    //数据状态：0为删除，1为正常
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getOrgTree() {
        return orgTree;
    }

    public void setOrgTree(String orgTree) {
        this.orgTree = orgTree;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
