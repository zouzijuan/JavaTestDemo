package org.example.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * program:20201203
 * description:
 * author:Zou zijuan
 * create:2020-12-03-01:07
 **/
public class DBUtilTest {

    @Test
    public void testConnection(){
        Assert.assertNotNull(DBUtil.getConnection());
    }

    @Test
    public void test() throws ClassNotFoundException {
        Class.forName("com.sss.OK");
    }
}
