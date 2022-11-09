package project.spotEEfy.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    public String ID_Song;

    public Song(String ID_Song) {
        this.ID_Song = ID_Song;
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

