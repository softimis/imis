package com.imis.frame.core.entity;

import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {
    //主键ID
    @TableId("ID")
    public String id;
    //数据状态：0为删除，1为正常
    public String status;
    //数据权限过滤预留字段
    public String org;
    //数据权限过滤预留字段
    public String orgTree;
    //创建人
    public String created;
    //创建时间
    public Date createTime;
    //修改人
    public String updated;
    //修改时间
    public Date updateTime;

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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
