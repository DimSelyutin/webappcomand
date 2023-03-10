package by.htp.ex.controller.impl;

import java.io.IOException;


import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;

import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.util.messageconst.MessageType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoDeleteNews implements Command {

    private final INewsService service = ServiceProvider.getInstance().getNewsService();
    private final String IDUSER = "idUser";
    private final String IDNEWS = "idNews";



    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String local = request.getSession().getAttribute("local").toString();
            String idUser = request.getSession().getAttribute(IDUSER).toString();

            String idNews = request.getParameter(IDNEWS);
            News news = service.findById(local, idNews);

            

            if ((news.getUserId() + "").equals(idUser)) {
                service.delete(idNews);
            } else {
                
                request.getSession().setAttribute(MessageType.EXCEPTION.getText(), "This post does not belong to you!");
            }

            request.getSession().setAttribute(MessageType.ACCESS.getText(), "Post was deleted!");
            response.sendRedirect("controller?command=go_to_main_page");

        } catch (ServiceException e) {
            request.setAttribute(MessageType.EXCEPTION.getText(), "Failed to delete post, service exception");
            request.getRequestDispatcher(MessageType.BASELINK.getText()).forward(request, response);

        }

    }

}
