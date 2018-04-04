package hls.cejoue.dto;

import hls.cejoue.model.Mtoken;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Timestamp;

/**
 * Created by hossiel on 15/02/2017.
 */

public class MtokenDto {


    private String id;

    private String username;


    private Timestamp creationDate;

    private  String jsessionid;


    private Timestamp lastDate;



    public MtokenDto() {
    }

    public MtokenDto(String username) {

    }

    public MtokenDto( String id,  String username, Timestamp creationDate,Timestamp lastDate, String jsessionid) {
        this.id = id;
        this.username=username;
        this.creationDate=creationDate;
        this.lastDate=lastDate;
        this.jsessionid=jsessionid;
    }
    public MtokenDto(Mtoken mtoken) {
        this.id =mtoken.getId();
        this.username=mtoken.getUsername();
        this.creationDate=mtoken.getCreationDate();
        this.lastDate=mtoken.getLastDate();
        this.jsessionid =mtoken.getJsessionid();
    }




    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getLastDate() {
        return this.lastDate;
    }

    public void setLastDate(Timestamp creationDate) {
        this.lastDate = lastDate;
    }

    public Timestamp getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getJsessionid() { return jsessionid; }

    public void setJsessionid(String jsessionid) { this.jsessionid = jsessionid; }

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
        final MtokenDto mtoken = (MtokenDto) obj;
        if (!id.equals(mtoken.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [UserName=").append(username).append("]").append("]").append("[id=").append(id).append("]");
        return builder.toString();
    }

}
