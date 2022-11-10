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

    public Like findLikeByUserAndPlaylist(User user, Playlist playlist) {
        return likeDAO.getLikeFromUserAndPlaylist(playlist.getID_Playlist(),user.getID_User());
    }

    public List<Like> getAllLikesFromUser(User user) { return likeDAO.getLikesFromUserID(user.getID_User());}

    public void likePlaylist(Playlist playlist, User user) {
        likeDAO.save(new Like(user, playlist));
    }
    public void unlikePlaylist(User user, Playlist playlist) {
        likeDAO.delete(findLikeByUserAndPlaylist(user, playlist));
    }
}
