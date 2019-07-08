package com.imis.project.entity;

import com.imis.frame.core.entity.BaseEntity;

public class TestEntity {
    public String username;
    public String password;

    public TestEntity() {
    }

    public TestEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
