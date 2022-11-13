package project.spotEEfy.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.spotEEfy.core.dao.PlaylistDAO;
import project.spotEEfy.core.entity.Playlist;
import project.spotEEfy.core.entity.Song;
import project.spotEEfy.core.exception.IDNotFoundException;
import project.spotEEfy.core.entity.User;


import java.util.List;
import java.util.Optional;

public class PlaylistService {
    private final static Logger log = LoggerFactory.getLogger(PlaylistService.class);


    private PlaylistDAO playlistDAO;

    public void playlistService(PlaylistDAO playlistDAO) {
        this.playlistDAO = playlistDAO;
    }

    public void savePlaylist(Playlist playlist){
        playlistDAO.save(playlist);
    }

    public void addSong(Playlist playlist,Song song){
        playlist.getSongs().add(song);
        playlistDAO.save(playlist);
    }

    public Playlist getPlaylistByID(String id) {
        return playlistDAO.findById(id).get();
    }

    //TODO: maybe  a save by id if we need it in the front
    //TODO: throw exception for PlaylistNotExistException
    public void deletePlaylistById(String playlistId) throws IDNotFoundException {
        Optional<Playlist> optionalPlaylist = playlistDAO.findById(playlistId);
        if(optionalPlaylist.isPresent()) {
            playlistDAO.deleteById(playlistId);
        } else {
            throw new IDNotFoundException("playlist ID");
        }
    }

    public Boolean doesUserHaveNoPlaylist(User user) {
        Boolean isNull=true;
        log.warn("PlaylistService User ID :"+user.getID_User());
        try {
            log.warn("PlaylistService List of playlist :"+getAllPlaylistFromUser(user.getID_User()).get(0));
            getAllPlaylistFromUser(user.getID_User()).get(0);
            isNull=false;
        }
        catch (Exception e) {
        }
        return isNull;
    }

    public List<Playlist> getAllPlaylistFromUser(String ID_user) {
        return playlistDAO.getAllPlaylistFromUser(ID_user);
    }

    public Boolean checkPlaylistExist(String playlist_id) {
        return playlistDAO.existsById(playlist_id);
    }


}


