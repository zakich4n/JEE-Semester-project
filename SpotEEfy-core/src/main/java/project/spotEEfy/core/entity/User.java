package project.spotEEfy.core.entity;

 
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String ID_User;

    private String email;
    private String username;
    private String password;
    private String Country;


    public User(String ID_User, String email, String username, String country) {
        this.ID_User = ID_User;
        this.email = email;
        this.username = username;
        this.Country = country;
    }



    public User() {

    }


    public void setID_User(String id) {
        this.ID_User = id;
    }


    public String getID_User() {
        return ID_User;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}


    