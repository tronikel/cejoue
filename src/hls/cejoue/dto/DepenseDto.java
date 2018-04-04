package hls.cejoue.dto;

import hls.cejoue.model.Depense;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hossiel on 15/02/2017.
 */

public class DepenseDto {

    public static final String DPLANTATION = "DPLANTATION";
    public static final String DMAISON = "DMAISON";
    public static final String DAUTRES = "DAUTRES";

    private int id;


    private String type;


    private Date dateEffective;


    private Date dateSoumission;


    private double montant;


    private String rapporteur;


    private String emetteur;


    private String commentaire;

    public DepenseDto(){

    }

    public DepenseDto(Depense depense) {
        this.id=depense.getId();
        this.type = depense.getType();
        this.dateEffective = new Date (depense.getDateEffective().getTime());
        this.dateSoumission = new Date (depense.getDateSoumission().getTime());
        this.montant = depense.getMontant();
        this.rapporteur = depense.getRapporteur();
        this.emetteur = depense.getEmetteur();
        this.commentaire = depense.getCommentaire();
    }

    public DepenseDto(int id,String type, Date dateEffective, Date dateSoumission, double montant,  String rapporteur, String emetteur, String commentaire) {
        this.id=id;
        this.type = type;
        this.dateEffective = dateEffective;
        this.dateSoumission = dateSoumission;
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

    public Date getDateEffective() {
        return dateEffective;
    }

    public void setDateEffective(Date dateEffective) {
        this.dateEffective = dateEffective;
    }

    public Date getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(Date dateSoumission) {
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
        final DepenseDto recette = (DepenseDto) obj;
        if (id !=recette.id) {
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
