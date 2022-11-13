package project.spotEEfy.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(value = {"songs"})
public class Playlist {

    @Id
    @Column
    private String ID_Playlist;

/*
    @ManyToOne
    @JoinColumn(name = "ID_User")
    private User user;

 */
    private String user;

    private String name;
    private String photo_url;

    @OneToMany
    private List<Song> songs;

    public Playlist(String ID_Playlist, String user, String name, String photo_url) {
        this.ID_Playlist = ID_Playlist;
        this.user = user;
        this.name = name;
        this.photo_url = photo_url;
        //this.songs = songs;
    }

    public Playlist() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setID_Playlist(String id_playlist) {
        this.ID_Playlist = id_playlist;
    }


    public String getID_Playlist() {
        return ID_Playlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }
}