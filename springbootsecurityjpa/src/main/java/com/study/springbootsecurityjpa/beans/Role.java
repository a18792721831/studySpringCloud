package com.study.springbootsecurityjpa.beans;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author jiayq
 * @Date 2020-03-20
 */
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setAuthority(String name){
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }

    @Override
    public String toString(){
        return name;
    }
}
