package project.spotEEfy.core.service;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;
import project.spotEEfy.core.dao.UserDAO;
import project.spotEEfy.core.entity.User;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@Service
@Transactional
public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void saveUser(User user) { userDAO.save(user); }

    //TODO: made this one with the exception idnotfound if needed
    public void deleteUser(User user) { userDAO.delete(user); }

    public long countAll() { return userDAO.count(); }

    public User findUserByEmail(String email) { return userDAO.getUserByEmail(email); }

    public List<User> findAll() { return userDAO.findAll(); }


    public User getUserById(long id) { return userDAO.getUserByID_User(id); }

    public List<User> getAllUsers() { return userDAO.getAllUsers(); }

}



