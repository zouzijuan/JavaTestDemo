package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * program:20201127
 * description:
 * author:Zou zijuan
 * create:2020-11-27-20:21
 **/
public class JSONUtil {
    private static final ObjectMapper MAPPER=new ObjectMapper();

    /**
     * 序列化操作:java对象序列化为json字符串
     * @param o java对象
     * @return json字符串
     */
    public static String serialize(Object o){
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("java对象序列化为json字符串失败："+o);
        }
    }

    /**
     * 反序列化输入流/字符串为java对象
     * @param is 输入流
     * @param clazz 指定要反序列化的java类型
     * @param <T>
     * @return反序列后的java对象
     */
    public static <T> T deserialize(InputStream is,Class<T> clazz){
        try {
            return MAPPER.readValue(is,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("反序列化失败");
        }
    }
}
