package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import by.htp.ex.util.messageconst.MessageType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ChangeLocale implements Command{


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute(MessageType.LOCAL.getText(), request.getParameter(MessageType.LOCAL.getText()));    
        String str = (String)request.getSession().getAttribute(MessageType.LINK.getText());
  
        response.sendRedirect(str);

    }
    
}
