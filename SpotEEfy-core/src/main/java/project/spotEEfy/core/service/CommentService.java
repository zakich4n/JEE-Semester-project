package project.spotEEfy.core.service;


import project.spotEEfy.core.dao.CommentDAO;
import project.spotEEfy.core.entity.Comment;
import project.spotEEfy.core.exception.IDNotFoundException;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;


@Named
@Transactional
public class CommentService {
    private CommentDAO commentDAO;

    public CommentService(CommentDAO commentDAO){
        this.commentDAO = commentDAO;
    }

    public void saveComment(Comment comment) {
        commentDAO.save(comment);
    }

    public void deleteComment(Comment comment){
        commentDAO.delete(comment);
    }

    public void deleteCommentById(Long commentId) throws IDNotFoundException {
        Optional<Comment> optionalComment = commentDAO.findById(commentId);
        if(optionalComment.isPresent()){
            commentDAO.deleteById(commentId);
        } else {
            throw new IDNotFoundException("Comment ID");
        }
    }

}


    