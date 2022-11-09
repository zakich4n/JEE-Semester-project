package project.spotEEfy.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spotEEfy.core.entity.Like;

public interface LikeDAO extends JpaRepository<Like, Long> {
}
