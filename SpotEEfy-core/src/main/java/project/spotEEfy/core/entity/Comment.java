package project.spotEEfy.core.entity;
 

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@JsonIgnoreProperties({"playlist","user"})
@Entity
public class Comment {

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;


    @ManyToOne
    @JoinColumn(name = "ID_User")
    private User user;

    @Column(name = "text")
    private String text;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Comment( User user, Playlist playlist, String text) {
        this.user = user;
        this.playlist = playlist;
        this.text = text;

    }

    public Comment() {}

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

   