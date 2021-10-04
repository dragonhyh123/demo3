package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String userName;
    private String passWord;
    private String realName;

    public int getId(){
        return this.id;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassWord(){
        return this.passWord;
    }

    public String getRealName(){
        return this.realName;
    }
}
