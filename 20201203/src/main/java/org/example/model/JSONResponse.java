package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * program:20201203
 * description:
 * author:Zou zijuan
 * create:2020-12-03-00:34
 **/
@Getter
@Setter
@ToString
public class JSONResponse {
    //业务操作是否成功
    private boolean success;
    //错误码：开发人员使用来定位问题
    private String code;
    //错误信息：给用户看的信息
    private String message;
    //业务数据
    private Object data;
}
