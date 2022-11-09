package project.spotEEfy.core.service;
 
import project.spotEEfy.core.dao.PlaylistDAO;
import project.spotEEfy.core.entity.Playlist;

import java.io.IOException;
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

    }


    //TODO: throw exception for PlaylistNotExistException
    public void deletePlaylistById(Long playlistId) throws IOException {
        Optional<Playlist> optionalPlaylist = playlistDAO.findById(playlistId);
        if(optionalPlaylist.isPresent()) {
            playlistDAO.deleteById(playlistId);
        } else {
            throw new IOException();
        }
    }
}


    