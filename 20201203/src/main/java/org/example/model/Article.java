package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * program:20201203
 * description:
 * author:Zou zijuan
 * create:2020-12-03-01:14
 **/
@Getter
@Setter
@ToString
public class Article {

    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Date createTime;
    private Integer viewCount;
}
