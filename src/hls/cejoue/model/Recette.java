package hls.cejoue.model;

import hls.cejoue.util.Util;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by hossiel on 15/02/2017.
 */
@Entity
@Table(name = "recette")
public class Recette {

    @Id()
    @GeneratedValue()
    @Column(name = "id_recette", nullable = false)
    private int id;

    @Column(name = "type", nullable = false, length = 45)
    private String type;

    @Column(name = "date_effective", nullable = false, length = 45)
    private Timestamp dateEffective;

    @Column(name = "date_soumission", nullable = false, length = 45)
    private Timestamp dateSoumission;

    @Column(name = "mois", nullable = false, length = 45)
    private Timestamp mois;

    @Column(name = "tonnage", nullable = false, length = 45)
    private double tonnage;

    @Column(name = "recette_brut", nullable = false, length = 45)
    private double recetteBrut;

    @Column(name = "recette_net", nullable = false, length = 45)
    private double recetteNet;

    @Column(name = "charge", nullable = false, length = 45)
    private double charge;

    @Column(name = "rapporteur", nullable = false, length = 45)
    private String rapporteur;

    @Column(name = "percepteur", nullable = false, length = 45)
    private String percepteur;

    @Column(name = "emetteur", nullable = false, length = 45)
    private String emetteur;


    @Column(name = "commentaire", nullable = false, length = 1000)
    private String commentaire;

    public Recette(){

    }

    public Recette(String type, Timestamp dateEffective, Timestamp dateSoumission, Timestamp mois, double tonnage, double recetteBrut, double recetteNet, double charge, String rapporteur, String percepteur, String emetteur,String commentaire) {
        this.type = type;
        this.dateEffective = dateEffective;
        this.dateSoumission = dateSoumission;
        this.tonnage = tonnage;
        this.recetteBrut = recetteBrut;
        this.recetteNet = recetteNet;
        this.charge = charge;
        this.rapporteur = rapporteur;
        this.percepteur = percepteur;
        this.emetteur = emetteur;
        this.mois = mois;
        this.commentaire = commentaire;
    }

    public Recette(String type, String dateEffective, String dateSoumission, String mois, double tonnage, double recetteBrut, double recetteNet, double charge, String rapporteur, String percepteur, String emetteur,String commentaire) {

        this.type = type;
        this.dateEffective = Util.convertStringToTimestamp(dateEffective);
        this.dateSoumission = Util.convertStringToTimestamp(dateSoumission);
        this.tonnage = tonnage;
        this.recetteBrut = recetteBrut;
        this.recetteNet = recetteNet;
        this.charge = charge;
        this.rapporteur = rapporteur;
        this.percepteur = percepteur;
        this.emetteur = emetteur;
        this.mois = Util.convertStringToTimestamp(mois);
        this.commentaire = commentaire;
    }
    public Recette(String type, Date dateEffective, Date mois, double tonnage, double recetteBrut, double recetteNet, double charge, String rapporteur, String percepteur, String emetteur, String commentaire) {

        this.type = type;
        this.dateEffective = new Timestamp(dateEffective.getTime());
        this.dateSoumission = new Timestamp(System.currentTimeMillis());
        this.tonnage = tonnage;
        this.recetteBrut = recetteBrut;
        this.recetteNet = recetteNet;
        this.charge = charge;
        this.rapporteur = rapporteur;
        this.percepteur = percepteur;
        this.emetteur = emetteur;
        this.mois = new Timestamp(mois.getTime());
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
        this.dateSoumission = date_soumission;
    }

    public Timestamp getMois() {
        return mois;
    }

    public void setMois(Timestamp mois) {
        this.mois = mois;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    public double getRecetteBrut() {
        return recetteBrut;
    }

    public void setRecetteBrut(double recetteBrut) {
        this.recetteBrut = recetteBrut;
    }

    public double getRecetteNet() {
        return recetteNet;
    }

    public void setRecetteNet(double recetteNet) {
        this.recetteNet = recetteNet;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public String getRapporteur() {
        return rapporteur;
    }

    public void setRapporteur(String rapporteur) {
        this.rapporteur = rapporteur;
    }

    public String getPercepteur() {
        return percepteur;
    }

    public void setPercepteur(String percepteur) {
        this.percepteur = percepteur;
    }

    public String getEmetteur() {        return emetteur;    }

    public void setEmetteur(String emetteur) {
        this.emetteur = emetteur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.percepteur = commentaire ;
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
        final Recette recette = (Recette) obj;
        if (id!=recette.id) {
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
