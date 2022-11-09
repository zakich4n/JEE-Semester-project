package project.spotEEfy.core.dao;
 
import org.springframework.data.jpa.repository.JpaRepository;
import project.spotEEfy.core.entity.Comment;
   
public interface CommentDAO extends JpaRepository<Comment, Long> {

}
