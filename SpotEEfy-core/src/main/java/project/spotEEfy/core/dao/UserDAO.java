package project.spotEEfy.core.dao;
 
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import project.spotEEfy.core.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface UserDAO extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE  u.email = :email")
    public User getUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.ID_User = :id")
    public User getUserByID_User(@Param("id") String id);

    @Query("SELECT u FROM User u")
    public List<User> getAllUsers();
}

