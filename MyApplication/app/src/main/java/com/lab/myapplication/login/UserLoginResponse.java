package com.lab.myapplication.login;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class UserLoginResponse implements Serializable {

    private String message;

    private String data;

    public UserLoginResponse(String message, String data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @NonNull
    @Override
    public String toString() {
        return message.toString();
    }
}

