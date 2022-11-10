package project.spotEEfy.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.spotEEfy.core.entity.Like;
import project.spotEEfy.core.entity.Playlist;

import java.util.List;

public interface LikeDAO extends JpaRepository<Like, Long> {

    @Query("SELECT l FROM Like l WHERE l.user = :id")
    public List<Like> getLikesFromUserID(@Param("id") String id);

    @Query("SELECT l FROM Like l WHERE l.user = :id_user AND l.playlist = :id_playlist")
    public Like getLikeFromUserAndPlaylist(@Param("id_playlist") String id_playlist, @Param("id_user") String id_user );

}
