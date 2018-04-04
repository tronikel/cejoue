package hls.cejoue.model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.security.SecureRandom;
import java.math.BigInteger;

/**
 * Created by hossiel on 15/02/2017.
 */
@Entity
@Table(name = "mtokens")
public class Mtoken {
    @Id
    @Column(name = "mtokenid", nullable = false)
    private String id;

    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "JSESSIONID")
    private String jsessionid;

    @Column(name = "creationDate")
    private Timestamp creationDate;

    @Column(name = "lastDate")
    private Timestamp lastDate;

  //  public static final int LIFE_TIME = 259200; /*** 60*60*24*3 => 3 Jours in second***/
    public static final int LIFE_TIME = 120; /*** 60*2 => 2 Minutes in second***/

    private static final SecureRandom random = new SecureRandom();

    public Mtoken() {
    }

    public Mtoken(String username) {
        this.username = username;
        this.creationDate = new Timestamp(System.currentTimeMillis());
        this.lastDate = new Timestamp(System.currentTimeMillis());
        this.id= new BigInteger(130, random).toString(32);
    }
    public Mtoken(String username, String jsessionid) {
        this.username = username;
        this.creationDate = new Timestamp(System.currentTimeMillis());
        this.lastDate = new Timestamp(System.currentTimeMillis());
        this.id= new BigInteger(130, random).toString(32);
        this.jsessionid=jsessionid;
    }




    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public  boolean isExpired(){
        return (new Timestamp(this.creationDate.getTime()+this.LIFE_TIME)).after(new Timestamp(System.currentTimeMillis()));
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
        final Mtoken mtoken = (Mtoken) obj;
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
