package hls.cejoue.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * Created by hossiel on 15/02/2017.
 */

public class UserNMtokenDto {

    @NotNull
    @Size(min = 1)
    private String Mt_id;

    @NotNull
    @Size(min = 1)
    private String Mt_username;

    @NotNull
    @Size(min = 1)
    private Timestamp Mt_creationDate;

    @NotNull
    @Size(min = 1)
    private Timestamp Mt_lastDate;

    @NotNull
    @Size(min = 1)
    private String username;

    @NotNull
    @Size(min = 1)
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @NotNull
    @Size(min = 1)
    private String email;

    @NotNull
    @Size(min = 1)
    private String nom;
    @NotNull
    @Size(min = 1)
    private String prenom;

    @NotNull
    @Size(min = 1)
    private Timestamp creationDate;





    public UserNMtokenDto() {
    }

    public UserNMtokenDto(String nom, String prenom, String username,String email, String password,String matchingPassword, Timestamp creationDate , String Mt_id, String Mt_username, Timestamp Mt_creationDate,Timestamp Mt_lastDate) {

        this.nom=nom;
        this.prenom=prenom;
        this.username=username;
        this.email=email;
        this.password=password;
        this.matchingPassword=matchingPassword;
        this.creationDate=creationDate;

        this.Mt_id=Mt_id;
        this.Mt_username= Mt_username;
        this.Mt_creationDate = Mt_creationDate;
        this.Mt_lastDate=Mt_lastDate;

    }




    public String getMTUsername() {
        return this.Mt_username;
    }

    public void setMTUsername(String Mt_username) {
        this.Mt_username = Mt_username;
    }


    public String geMTtId() {
        return this.Mt_id;
    }

    public void setMTId(String Mt_id) {
        this.Mt_id = Mt_id;
    }

    public Timestamp getMTLastDate() {
        return this.Mt_lastDate;
    }

    public void setMTLastDate(Timestamp Mt_creationDate) {
        this.Mt_lastDate = Mt_lastDate;
    }

    public Timestamp geMTtCreationDate() {
        return this.Mt_creationDate;
    }

    public void setMTCreationDate(Timestamp Mt_creationDate) {
        this.Mt_creationDate = Mt_creationDate;
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

    public void setUsesname(final String username) {
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
        final UserNMtokenDto userNmtoken = (UserNMtokenDto) obj;
        if (!Mt_id.equals(userNmtoken.Mt_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [UserName=").append(Mt_username).append("]").append("]").append("[Mt_id=").append(Mt_id).append("]");
        return builder.toString();
    }

}
