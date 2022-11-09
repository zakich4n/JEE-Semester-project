package project.spotEEfy.core.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Like{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private User user;

    @OneToOne
    private Playlist playlist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Like(User user,Playlist playlist, Long id) {
        this.user = user;
        this.playlist = playlist;
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


    