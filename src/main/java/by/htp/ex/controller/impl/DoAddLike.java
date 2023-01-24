package by.htp.ex.controller.impl;

import java.io.IOException;
import java.sql.SQLException;

import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class DoAddLike implements Command {

    private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
    private final String IDUSER = "idUser";
    private final String IDNEWS = "idNews";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String idNews = request.getParameter(IDNEWS);
        System.out.println(idNews);
        String idUser = request.getSession().getAttribute(IDUSER).toString();
        try {
            newsService.addLike(idUser, idNews);
        } catch (ServiceException e) {
            request.setAttribute("exception", "Error to add like for news!");
        }
    }


}