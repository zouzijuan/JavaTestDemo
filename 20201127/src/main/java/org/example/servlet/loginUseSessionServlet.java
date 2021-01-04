package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * program:20201127
 * description:
 * author:Zou zijuan
 * create:2020-11-27-20:04
 **/

//服务路径必须以/开头，否则tomcat会报错
@WebServlet("/loginUseSession")
public class loginUseSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

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
        //模拟用户名密码登录：登陆成功
        if("abc".equals(username)&&"123".equals(password)){
            //获取session对象（从服务器）
            //如果方法参数为true，表示如果没有的话，就创建一个
            //如果为false，表示没有就返回null
            HttpSession session=req.getSession();//无参默认为true;
            session.setAttribute("user",
                    String.format("username=%s,password=%s",username,password));
            pw.println("登录成功");
        } else{
            pw.println("登录失败");
        }
        pw.flush();
        pw.close();
    }
}
