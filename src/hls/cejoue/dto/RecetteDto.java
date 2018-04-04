package hls.cejoue.dto;

import hls.cejoue.model.Recette;

import java.util.Date;


/**
 * Created by hossiel on 15/02/2017.
 */

public class RecetteDto {

    public static final String RCOUPE = "RCOUPE";
    public static final String RLOYER = "RLOYER";
    public static final String RAUTRES = "RAUTRES";

    private int id;


    private String type;


    private Date dateEffective;


    private Date dateSoumission;

    private Date mois;


    private double tonnage;


    private double recetteBrut;


    private double recetteNet;


    private double charge;


    private String rapporteur;


    private String percepteur;

    private String emetteur;


    private String commentaire;

    public RecetteDto(){

    }

    public RecetteDto(Recette recette) {
        this.id=recette.getId();
        this.type = recette.getType();
        this.dateEffective = new Date (recette.getDateEffective().getTime());
        this.dateSoumission = new Date (recette.getDateSoumission().getTime());
        this.tonnage = recette.getTonnage();
        this.recetteBrut = recette.getRecetteBrut();
        this.recetteNet = recette.getRecetteNet();
        this.charge = recette.getCharge();
        this.rapporteur = recette.getRapporteur();
        this.percepteur = recette.getPercepteur();
        this.commentaire = recette.getCommentaire();
        this.mois =  new Date (recette.getMois().getTime());
        this.emetteur=recette.getEmetteur();
    }

    public RecetteDto(int id, String type, Date dateEffective, Date dateSoumission, Date mois, double tonnage, double recetteBrut, double recetteNet, double charge, String rapporteur, String percepteur, String emetteur, String commentaire) {
        this.id=id;
        this.type = type;
        this.dateEffective = dateEffective;
        this.dateSoumission = dateSoumission;
        this.tonnage = tonnage;
        this.recetteBrut = recetteBrut;
        this.recetteNet = recetteNet;
        this.charge = charge;
        this.rapporteur = rapporteur;
        this.percepteur = percepteur;
        this.commentaire = commentaire;
        this.emetteur = emetteur;
        this.mois= mois;
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

    public Date getMois() {
        return mois;
    }

    public void setMois(Date mois) {
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
        final RecetteDto recette = (RecetteDto) obj;
        if (id!=recette.getId()) {
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
