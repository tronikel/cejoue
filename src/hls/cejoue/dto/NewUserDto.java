package hls.cejoue.dto;


import hls.cejoue.model.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class NewUserDto {
    @NotNull
    @Size(min = 1)
    private String nom;
    @NotNull
    @Size(min = 1)
    private String prenom;

    @NotNull
    @Size(min = 1)
    private String username;
    @NotNull
    @Size(min = 1)
    private String email;

    @NotNull
    @Size(min = 1)
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @NotNull
    @Size(min = 1)
    private Timestamp creationDate;
    public NewUserDto(){

    }

    public NewUserDto(String nom, String prenom, String username, String email, String password, String matchingPassword, Timestamp creationDate ) {

        this.nom=nom;
        this.prenom=prenom;
        this.username=username;
        this.email=email;
        this.password=password;
        this.matchingPassword=matchingPassword;
        this.creationDate=creationDate;

    }

    public NewUserDto(User user) {

        this.nom=user.getNom();
        this.prenom=user.getPrenom();
        this.username=user.getUsername();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.matchingPassword=user.getPassword();
        this.creationDate=user.getCreationDate();

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(final String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public Timestamp getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [UserName=").append(username).append("]").append("]").append("[email").append(email).append("]");
        return builder.toString();
    }
}
