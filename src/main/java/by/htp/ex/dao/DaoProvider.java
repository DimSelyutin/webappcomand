package by.htp.ex.dao;

import by.htp.ex.dao.impl.CommentDAO;
import by.htp.ex.dao.impl.NewsDAO;
import by.htp.ex.dao.impl.UserDAO;

public final class DaoProvider {

    private static final DaoProvider instance = new DaoProvider();

    private final INewsDAO newsDAO = new NewsDAO();
    private final IUserDAO userDAO = new UserDAO();
    private final ICommentDAO commentDAO = new CommentDAO();

    
    private DaoProvider() {

    }
    
    public ICommentDAO getCommentDAO()  {
        return commentDAO;
    }
    
    public IUserDAO getUserDAO() {

        return userDAO;
    }

    public INewsDAO getNewsDAO() {
        return newsDAO;
    }

 

    public static DaoProvider getInstance() {
        return instance;
    }

}
