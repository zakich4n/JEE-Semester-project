package project.spotEEfy.core.dao;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.spotEEfy.core.entity.Comment;
import project.spotEEfy.core.entity.Playlist;
import project.spotEEfy.core.entity.User;
import java.util.List;

public interface CommentDAO extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.playlist = :id")
    public List<Comment> findByPlaylist(@Param("id") Playlist id);
}
