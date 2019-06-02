package com.hesoyam.server.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User {
    @Id
    private ObjectId _id;
    private String username;
    private String password;
    private String passwordConfirm;

    public User(){

    }

    public User(ObjectId _id, String username, String password, String passwordConfirm) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }


}
