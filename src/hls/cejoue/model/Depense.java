package hls.cejoue.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by hossiel on 15/02/2017.
 */
@Entity
@Table(name = "depense")
public class Depense {

    @Id()
    @GeneratedValue()
    @Column(name = "id_depense", nullable = false)
    private int id;

    @Column(name = "type", nullable = false, length = 45)
    private String type;

    @Column(name = "date_effective", nullable = false, length = 45)
    private Timestamp dateEffective;

    @Column(name = "date_soumission", nullable = false, length = 45)
    private Timestamp dateSoumission;

    @Column(name = "montant", nullable = false, length = 45)
    private double montant;



    @Column(name = "rapporteur", nullable = false, length = 45)
    private String rapporteur;

    @Column(name = "emetteur", nullable = false, length = 45)
    private String emetteur;

    @Column(name = "commentaire", nullable = false, length = 1000)
    private String commentaire;

    public Depense(){

    }

    public Depense(String type, Timestamp dateEffective, Timestamp dateSoumission, double montant, String rapporteur, String emetteur, String commentaire) {
        this.type = type;
        this.dateEffective = dateEffective;
        this.dateSoumission = dateSoumission;
        this.montant = montant;
        this.rapporteur = rapporteur;
        this.emetteur = emetteur;
        this.commentaire = commentaire;
    }

    public Depense(String type, Date dateEffective, double montant, String rapporteur, String emetteur, String commentaire) {
        this.type = type;
        this.dateEffective = new Timestamp(dateEffective.getTime());
        this.dateSoumission = new Timestamp(System.currentTimeMillis());
        this.montant = montant;
        this.rapporteur = rapporteur;
        this.emetteur = emetteur;
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDateEffective() {
        return dateEffective;
    }

    public void setDateEffective(Timestamp dateEffective) {
        this.dateEffective = dateEffective;
    }

    public Timestamp getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(Timestamp date_soumission) {
        this.dateSoumission = dateSoumission;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getRapporteur() {
        return rapporteur;
    }

    public void setRapporteur(String rapporteur) {
        this.rapporteur = rapporteur;
    }

    public String getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(String emetteur) {
        this.emetteur = emetteur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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
        final Depense depense = (Depense) obj;
        if (id !=depense.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [ID=").append(id).append("]").append("]").append("[type").append(type).append("]");
        return builder.toString();
    }


}
