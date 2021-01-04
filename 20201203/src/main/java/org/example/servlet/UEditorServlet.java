package org.example.servlet;

import org.example.util.MyActionEnter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;

/**
 * program:20201203
 * description:
 * author:Zou zijuan
 * create:2020-12-05-19:41
 **/
@WebServlet("/ueditor")
public class UEditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL url=UEditorServlet.class.getClassLoader()
                .getResource("config.json");
        String path= URLDecoder.decode(url.getPath(),"UTF-8");
        MyActionEnter enter=new MyActionEnter(req,path);
        String exec=enter.exec();
        PrintWriter pw=resp.getWriter();
        pw.write(exec);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
