package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.util.messageconst.MessageType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToAddTranslate implements Command {

    private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
    private final String IDNEWS = "idNews";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idNews = request.getParameter(IDNEWS);
        News post;
        try {
            String local = request.getSession().getAttribute("local").toString();
            
            post = newsService.findById(local, idNews);
            post.setId(Integer.parseInt(idNews));
            

            request.setAttribute("presentation", "newsTranslate");
            request.setAttribute("link", "/WEB-INF/pages/tiles/addTranslate.jsp");
            request.setAttribute("post", post);
            request.getRequestDispatcher(MessageType.BASELINK.getText()).forward(request, response);

        } catch (ServiceException e) {
            request.setAttribute(MessageType.EXCEPTION.getText(), e.getMessage());
            request.getRequestDispatcher(MessageType.BASELINK.getText()).forward(request, response);

        }

    }

}
