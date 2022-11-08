package project.spotEEfy.core.entity;


import javax.persistence.Entity;

@Entity
public class Like implements Comparable<Like>{
    private Long ID_User;
    private Long ID_Playlist;

    public Like(Long ID_User, Long ID_Playlist, String text) {
        this.ID_User = ID_User;
        this.ID_Playlist = ID_Playlist;
        this.text = text;
    }

    public Like(){
    }

    public Long getID_User() {
        return ID_User;
    }

    public void setID_User(Long ID_User) {
        this.ID_User = ID_User;
    }

    public Long getID_Playlist() {
        return ID_Playlist;
    }

    public void setID_Playlist(Long ID_Playlist) {
        this.ID_Playlist = ID_Playlist;
    }

    @Override
    public int compareTo(Like o) {
        return 0;
    }
}
