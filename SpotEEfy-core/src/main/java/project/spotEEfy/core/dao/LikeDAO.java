package project.spotEEfy.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.spotEEfy.core.entity.Like;
import project.spotEEfy.core.entity.Playlist;

import java.util.List;

public interface LikeDAO extends JpaRepository<Like, Long> {

    @Query("SELECT l FROM Like l WHERE  l.user = :id")
    public List<Like> getAllLikesFromUser(@Param("id") Long id);
}
