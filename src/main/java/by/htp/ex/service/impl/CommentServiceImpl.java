package by.htp.ex.service.impl;

import java.util.List;
import by.htp.ex.bean.Comment;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.ICommentDAO;
import by.htp.ex.service.ICommentService;
import by.htp.ex.service.ServiceException;

public class CommentServiceImpl implements ICommentService {

    private ICommentDAO commentDao = DaoProvider.getInstance().getCommentDAO();

    @Override
    public List<Comment> findCommentOfPost(String id) throws ServiceException {
        List<Comment> comments = null;
        try {
            comments = commentDao.findAllComment(id);
            return comments;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addComment(Comment comment) throws ServiceException {
        try {
            commentDao.creatComment(comment);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void chageComment(Comment comment, String userId) throws ServiceException {
        try {
            commentDao.changeComment(comment);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public boolean deleteComment(String commentId) throws ServiceException {
        try {
            return commentDao.deleteComment(commentId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public Comment findCommentById(String commentId) throws ServiceException {
        Comment comment = null;
        try {
            comment = commentDao.findCommentById(commentId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return comment;
    }
}
