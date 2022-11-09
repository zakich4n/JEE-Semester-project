package project.spotEEfy.core.service;

import project.spotEEfy.core.dao.PlaylistDAO;
import project.spotEEfy.core.entity.Playlist;
import project.spotEEfy.core.entity.Song;
import project.spotEEfy.core.exception.IDNotFoundException;

import java.io.IOException;
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
}


