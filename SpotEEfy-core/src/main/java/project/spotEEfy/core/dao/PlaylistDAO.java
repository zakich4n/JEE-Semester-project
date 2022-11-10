package project.spotEEfy.core.dao;
 
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import project.spotEEfy.core.entity.Playlist;
import project.spotEEfy.core.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface PlaylistDAO extends JpaRepository<Playlist, Long> {

    @Query("SELECT p FROM Playlist p WHERE p.user = :id")
    public List<Playlist> getAllPlaylistFromUser(@Param("id") String id);
}
   
