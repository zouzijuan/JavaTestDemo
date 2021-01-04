package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.exception.AppException;
import org.example.model.Article;
import org.example.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * program:20201203
 * description:
 * author:Zou zijuan
 * create:2020-12-03-14:37
 **/
@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取请求数据：用户id（前端写死了的数据）
        //String id = req.getParameter("id");
        HttpSession session = req.getSession(false);
        if(session == null){
            throw new AppException("ART002", "没有登录，不允许访问");
        }
        User user = (User) session.getAttribute("user");
        if(user == null)
            throw new AppException("ART002", "没有登录，不允许访问");

        //根据用户id查询文章列表
        List<Article> articles = ArticleDAO.queryByUserId(user.getId());
        return articles;
    }
}
