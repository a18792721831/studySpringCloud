package com.study.springbootjpa.beans;

import com.study.springbootjpa.convert.StatusConvert;
import com.study.springbootjpa.neum.Status;

import javax.persistence.*;

/**
 * @author jiayq
 * @Date 2020-02-18
 */
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

    @Convert(converter = StatusConvert.class)
    @Column(nullable = false, name = "STATUS")
    private Status status;

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Users(id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", status=" + this.getStatus() + ")";
    }
}
