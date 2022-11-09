package project.spotEEfy.core.entity;
/*

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@JsonIgnoreProperties({"playlist","user"})
@Entity
public class Comment {

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Playlist playlist;


    //TODO: See if we do it like that
    //OneToMany(mappedBy=)
    @ManyToOne
    @JoinColumn(name = "user_id_user")
    private User user;


    private String text;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public User getUser() {
        return user;
    }



    public Comment(Long id, Long ID_User, Long ID_Playlist, String text) {
        this.id = id;
        //this.ID_User = ID_User;
        //this.ID_Playlist = ID_Playlist;
        this.text = text;

    }

    public Comment() {}

    /*
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



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

*/