package project.spotEEfy.core.service;

import project.spotEEfy.core.dao.CommentDAO;
import project.spotEEfy.core.dao.LikeDAO;
import project.spotEEfy.core.entity.Like;
import project.spotEEfy.core.entity.Playlist;
import project.spotEEfy.core.entity.User;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;


@Named
@Transactional
public class LikeService {
    private LikeDAO likeDAO;

    public LikeService(LikeDAO likeDAO){
        this.likeDAO = likeDAO;
    }

    public void userLikedPlaylist(User user, Playlist playlist) {
        //create new like with ID playlist and ID User
    }

    public void removeLikeFromPlaylist(User user, Playlist playlist) {
        //remove like with ID playlist and ID User
    }

    public List<Like> getAllLikeOfUser(User user, Playlist playlist) {
        return likeDAO.getAllLikesFromUser(user.getID_User());
    }

}
