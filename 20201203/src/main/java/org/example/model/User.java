package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * program:20201203
 * description:
 * author:Zou zijuan
 * create:2020-12-03-01:12
 **/
@Getter
@Setter
@ToString
public class User {

    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private Date birthday;
    private String phoneNumber;
    private String email;
    private String head;
}
