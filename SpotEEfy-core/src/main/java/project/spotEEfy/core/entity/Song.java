package project.spotEEfy.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    public String ID_Song;

    public String artist;
    public String name;
    public String duration;

    public String album;
    public String photo;

    public Song(String artist,String name, String duration,String album,String photo) {
        this.artist=artist;
        this.name=name;
        this.duration=duration;
        this.album=album;
        this.photo=photo;
    }

    public Song() {
    }

    public String getID_Song() {
        return ID_Song;
    }

    public void setID_Song(String ID_Song) {
        this.ID_Song = ID_Song;
    }
}

