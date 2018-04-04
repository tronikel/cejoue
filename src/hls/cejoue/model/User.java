package hls.cejoue.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by hossiel on 22/06/2016.
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Column(name = "email")
    private String email;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;

    @Column(name = "creationDate")
    @Type(type="timestamp")
    private Timestamp creationDate;


    public User() {
    }

    public User(String username, String password,String email,String nom, String prenom,Timestamp creationDate) {
        this.username = username;
        this.password = password;
        this.email= email;
        this.nom= nom;
        this.prenom=prenom;
        this.creationDate=creationDate;
    }

    public User(String username, String password,String email,String nom, String prenom) {
        this.username = username;
        this.password = password;
        this.email= email;
        this.nom= nom;
        this.prenom=prenom;
        this.creationDate=new Timestamp(System.currentTimeMillis());
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String username) {
        this.email = username;
    }


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public Timestamp getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }




    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User user = (User) obj;
        if (!email.equals(user.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [UserName=").append(username).append("]").append("]").append("[email").append(email).append("]");
        return builder.toString();
    }

}

