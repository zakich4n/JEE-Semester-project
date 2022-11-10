package project.spotEEfy.core.service;

import project.spotEEfy.core.dao.PlaylistDAO;
import project.spotEEfy.core.entity.Playlist;
import project.spotEEfy.core.entity.Song;
import project.spotEEfy.core.exception.IDNotFoundException;
import project.spotEEfy.core.entity.User;


import java.util.List;
import java.util.Optional;

public class PlaylistService {

    private PlaylistDAO playlistDAO;

    public void playlistService(PlaylistDAO playlistDAO) {
        this.playlistDAO = playlistDAO;
    }

    public void savePlaylist(Playlist playlist){
        playlistDAO.save(playlist);
    }

    public void addSong(Playlist playlist, String ID_Song){
        Song song = new Song(ID_Song);
        playlist.addSong(song);
        playlistDAO.save(playlist);
    }

    public Playlist getPlaylistByID(Long id) {
        return playlistDAO.findById(id).get();
    }

    //TODO: maybe  a save by id if we need it in the front
    //TODO: throw exception for PlaylistNotExistException
    public void deletePlaylistById(Long playlistId) throws IDNotFoundException {
        Optional<Playlist> optionalPlaylist = playlistDAO.findById(playlistId);
        if(optionalPlaylist.isPresent()) {
            playlistDAO.deleteById(playlistId);
        } else {
            throw new IDNotFoundException("playlist ID");
        }
    }

    public Boolean doesUserHaveNoPlaylist(User user) {
        Boolean isNull=true;
        try {
            getAllPlaylistFromUser(user.getID_User()).get(1);
            isNull=false;
        }
        catch (Exception e) {


        }

        return isNull;
    }

    public List<Playlist> getAllPlaylistFromUser(String ID_user) {
        return playlistDAO.getAllPlaylistFromUser(ID_user);
    }
}


