package by.htp.ex.controller.impl;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import by.htp.ex.bean.Category;
import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.connectionpool.ConnectionPoolException;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.util.messageconst.MessageType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToNews implements Command {

    private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
    private final String PRESENTATION = "news";
    private final String CATEGORY = "category";
    private final String IDUSER = "idUser";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String local = request.getSession().getAttribute("local")+"";
        String userId = (request.getSession().getAttribute(IDUSER)+"");

        String category = null;
        List<News> newsList;
        try {
            List<String> likedNews = newsService.getLikedNews(userId);
            category = request.getParameter(CATEGORY);
            if (category == null) {
                newsList = newsService.list(local);
            } else if (category.equals("sortbydate")) {
                newsList = newsService.sortByDate(local);
            } else {
                newsList = newsService.sortByCategory(category);
            }
            request.setAttribute(PRESENTATION, newsList);
            request.setAttribute("likedNews", likedNews);

            request.getRequestDispatcher(MessageType.BASELINK.getText()).forward(request, response);
        } catch (ServiceException e) {
            request.setAttribute(MessageType.EXCEPTION.getText(), e.getMessage());
            request.getRequestDispatcher(MessageType.BASELINK.getText()).forward(request, response);
        }
    }

}
