package project.spotEEfy.core.entity;


import javax.persistence.*;

@Entity
public class Like{
    @Id
    private Long id;

    @OneToOne
    private User user;

    @OneToOne
    private Playlist playlist;

    public Like(User user, Playlist playlist) {
        this.user = user;
        this.playlist = playlist;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Like(){
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}


    