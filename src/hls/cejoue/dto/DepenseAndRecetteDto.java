package hls.cejoue.dto;

import hls.cejoue.model.Depense;
import hls.cejoue.model.Recette;
import java.util.List;
import java.util.Date;

/**
 * Created by hossiel on 15/02/2017.
 */

public class DepenseAndRecetteDto {

    public static final String DPLANTATION = "DPLANTATION";
    public static final String DMAISON = "DMAISON";
    public static final String DAUTRES = "DAUTRES";

    public static final String RCOUPE = "RCOUPE";
    public static final String RLOYER = "RLOYER";
    public static final String RAUTRES = "RAUTRES";





    private Date dateEffective;


    private Date dateSoumission;


    private int id;


    private String type;


    private Date mois;


    private double montant;


    private String rapporteur;


    private String emetteur;


    private String commentaire;

    private double tonnage;


    private double recetteBrut;


    private double recetteNet;


    private double charge;



    private String percepteur;


    public DepenseAndRecetteDto(){

    }





    public  DepenseAndRecetteDto(RecetteDto recette) {
        this.id=recette.getId();
        this.type = recette.getType();
        this.dateEffective = new Date(recette.getDateEffective().getTime());
        this.dateSoumission = new Date(recette.getDateSoumission().getTime());
        this.tonnage = recette.getTonnage();
        this.recetteBrut = recette.getRecetteBrut();
        this.recetteNet = recette.getRecetteNet();
        this.montant = recette.getRecetteNet();
        this.charge = recette.getCharge();
        this.rapporteur = recette.getRapporteur();
        this.percepteur = recette.getPercepteur();
        this.commentaire = recette.getCommentaire();
        this.mois = new Date(recette.getMois().getTime());
        this.emetteur=recette.getEmetteur();
        this.mois=recette.getMois();
    }

    public DepenseAndRecetteDto(DepenseDto depense) {
        this.id=depense.getId();
        this.type = depense.getType();
        this.dateEffective = depense.getDateEffective();
        this.dateSoumission = depense.getDateSoumission();
        this.montant = depense.getMontant();
        this.recetteNet= depense.getMontant();
        this.rapporteur = depense.getRapporteur();
        this.emetteur = depense.getEmetteur();
        this.commentaire = depense.getCommentaire();
    }

    public DepenseAndRecetteDto(int id, String type, Date dateEffective, Date dateSoumission,Date mois, double tonnage, double recetteBrut, double recetteNet, double charge, String rapporteur, String percepteur, String emetteur, String commentaire) {
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
        this.mois=mois;
        this.emetteur=emetteur;
    }

    public DepenseAndRecetteDto(int id, String type, Date dateEffective, Date dateSoumission, double montant, String rapporteur, String emetteur, String commentaire) {
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

    public void setDateSoumission(Date date_soumission) {
        this.dateSoumission = dateSoumission;
    }

    public Date getMois() {
        return mois;
    }

    public void setMois(Date mois) {
        this.mois = mois;
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
        this.emetteur = commentaire;
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

    public String getPercepteur() {
        return percepteur;
    }

    public void setPercepteur(String percepteur) {
        this.percepteur = percepteur;
    }


    public static  List<DepenseAndRecetteDto> sortByCreationDate(List<DepenseAndRecetteDto> list){

        List<DepenseAndRecetteDto> sortedList = list;

        return sortedList;
    }

    public  DepenseAndRecetteDto afterByCreationDate(DepenseAndRecetteDto d1, DepenseAndRecetteDto d2){
        return (d1.getDateSoumission().after(d2.getDateSoumission())? d1: d2);
    }

    public  boolean afterByCreationDate(DepenseAndRecetteDto d1){
        return (this.getDateSoumission().after(d1.getDateSoumission())) ? true : false;
    }


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [ID=").append(id).append("]").append("]").append("[type").append(type).append("]");
        return builder.toString();
    }


}
