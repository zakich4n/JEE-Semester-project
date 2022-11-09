package project.spotEEfy.core.entity;

 
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long ID_User;

    private String email;
    private String username;
    private String password;
    private int Age;
    private String sexe;
    private String Country;

    public User(Long ID_User, String email, String username, String password, int age, String sexe, String country) {
        this.ID_User = ID_User;
        this.email = email;
        this.username = username;
        this.password = password;
        this.Age = age;
        this.sexe = sexe;
        this.Country = country;
    }



    public User() {

    }


    public void setID_User(Long id) {
        this.ID_User = id;
    }


    public Long getID_User() {
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

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}


    