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
 * create:2020-11-28-11:21
 **/
@WebServlet("/sen")
public class SensitiveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        PrintWriter pw=resp.getWriter();
        //敏感资源，需要使用false传参，如果没有，返回null
        HttpSession session=req.getSession(false);
        if(session==null){
            resp.setStatus(401);//没有登陆，unauthorized;
            pw.println("没有登录，不允许访问");
        }else{
            //伪代码
            /*User user=(User)session.getAttribute("user");
            if(user.允许访问的资源不包括当前访问的服务路径){
                resp.setStatus(403);//没有权限,forbidden;
                pw.println("没有权限，禁止访问");
            }else {
                pw.println("访问成功");
            }*/
            pw.println("访问成功");

        }
    }
}
