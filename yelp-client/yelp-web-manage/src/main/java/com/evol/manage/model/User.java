package com.evol.manage.model;

import lombok.Data;

@Data
public class User {

    public User(){}

    public User(Long id, String username, String pasword, String nick){
        this.id = id;
        this.username = username;
        this.password = pasword;
        this.nick = nick;
    }


    private Long id;

    private String username;

    private String password;

    private String nick;
}