package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;
import org.example.model.User;
import org.example.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;

/**
 * program:20201203
 * description:
 * author:Zou zijuan
 * create:2020-12-04-16:25
 **/
@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        InputStream is=req.getInputStream();
        Article article= JSONUtil.deserialize(is,Article.class);
        int num= ArticleDAO.update(article);
        return null;
    }
}
