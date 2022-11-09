package project.spotEEfy.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Playlist {

    private Long ID_Playlist;
    private Long ID_User;
    private String name;
    private String photo_url;
    private ArrayList<Object> Songs= new ArrayList<Object>();
    private String ID_Song;

    public Playlist(Long ID_Playlist, Long ID_User, String name, String photo_url, ArrayList<Object> songs, String ID_Song) {
        this.ID_Playlist = ID_Playlist;
        this.ID_User = ID_User;
        this.name = name;
        this.photo_url = photo_url;
        Songs = songs;
        this.ID_Song = ID_Song;
    }

    public Playlist() {
    }

    public void setID_Playlist(Long id_playlist) {
        this.ID_Playlist = id_playlist;
    }

    @Id
    public Long getID_Playlist() {
        return ID_Playlist;
    }

    public Long getID_User() {
        return ID_User;
    }

    public void setID_User(Long ID_User) {
        this.ID_User = ID_User;
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

    public String getSongs() {
        return Songs.toString();
    }

    public void setSongs(ArrayList<Object> songs) {
        Songs = songs;
    }

    public String getID_Song() {
        return ID_Song;
    }

    public void setID_Song(String ID_Song) {
        this.ID_Song = ID_Song;
    }
}
