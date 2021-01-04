package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * program:20201127
 * description:
 * author:Zou zijuan
 * create:2020-11-27-20:04
 **/

//服务路径必须以/开头，否则tomcat会报错
@WebServlet("/loginJSON")
public class loginJSONServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String username=req.getParameter("username");
        String password=req.getParameter("password");

        System.out.printf("username=%s,password=%s%n",username,password);

        PrintWriter pw=resp.getWriter();

        /*//伪代码，用户登录的jdbc校验
        if(LoginDAO.query(username,password)) {
            pw.println(JSON字符串);
        }else {
            pw.println(JSON字符串);
        }*/
        pw.flush();
        pw.close();
    }
}
