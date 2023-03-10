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

public class DoAddTranslate implements Command {
    private final INewsService service = ServiceProvider.getInstance().getNewsService();
    private final String CATEGORY = "category";
    private final String TITLE = "title";
    private final String POSTTEXT = "postText";
    private final String IDUSER = "idUser";
    private final String IDNEWS = "idNews";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCategory = request.getParameter(CATEGORY);
        String idNews = request.getParameter(IDNEWS);
        String title = request.getParameter(TITLE);
        String text = request.getParameter(POSTTEXT);
        String category = request.getParameter(CATEGORY);
        String local = request.getSession().getAttribute("local").toString();

        String imageDir = "";
        if (local.equals("en")) {
            local = "ru";
        } else {
            local = "en";
        }

        try {
            int userId = (int) request.getSession().getAttribute(IDUSER);

            News editedNews;
            editedNews = new News(Integer.parseInt(idNews),title, text, imageDir, category, userId, local);

            if (!service.saveTranslate(editedNews)) {
                throw new ServiceException("Error save post!");
            }
            request.getSession().setAttribute("access", "Translate was added!");
            response.sendRedirect("controller?command=go_to_main_page");
        } catch (ServiceException e) {
            request.setAttribute(MessageType.EXCEPTION.getText(), "Error to add news!");
            request.getRequestDispatcher(MessageType.BASELINK.getText()).forward(request, response);

        }
    }

}
