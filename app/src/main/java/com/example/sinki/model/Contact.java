package com.example.sinki.model;

import java.io.Serializable;

/**
 * Created by Sinki on 8/28/2017.
 */

public class Contact implements Serializable {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return this.name + "\n" + this.phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
