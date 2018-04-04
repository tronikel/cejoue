package hls.cejoue.DAO;

import hls.cejoue.dto.RecetteDto;
import hls.cejoue.model.Recette;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class RecetteDaoImpl implements RecetteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Recette findById(int id) {

		List<Recette> recettes = new ArrayList<Recette>();

		recettes = sessionFactory.getCurrentSession().createQuery("from Recette where id=?").setParameter(0, id)
				.list();

		if (recettes.size() > 0) {
			return recettes.get(0);
		} else {
			return null;
		}

	}
	public RecetteDto deleteRecette (RecetteDto recette){
		Recette recette1=	findById(recette.getId());
		RecetteDto recetteX=null;
		if (recette1!= null) {
			sessionFactory.getCurrentSession().delete(recette1);
			recetteX= new RecetteDto();
		}
		return recetteX;
	}
	public Recette createRecette (RecetteDto recette){
		Recette recette1=	findById(recette.getId());

		if (recette1== null) {
			recette1 = new Recette(recette.getType()  ,recette.getDateEffective()  , recette.getMois(),recette.getTonnage(),recette.getRecetteBrut(),recette.getRecetteNet(),recette.getCharge() ,recette.getRapporteur()  ,recette.getPercepteur() ,recette.getEmetteur() ,recette.getCommentaire()  );
			sessionFactory.getCurrentSession().save(recette1);
		}else{
			return null;
		}

		return recette1;
	}

	public  Recette updateRecette(RecetteDto recette) {

		boolean updated=false ;
		Recette recette1 = findById(recette.getId());
		if (recette1 != null) {
			if (recette.getType() != null) {
				recette1.setType(recette.getType());
				updated=true;
			}
			if (recette.getDateEffective() != null) {
				recette1.setDateEffective(new Timestamp(recette.getDateEffective().getTime()));
				updated=true;

			}
			if (recette.getDateSoumission() != null) {
				recette1.setDateSoumission(new Timestamp(recette.getDateSoumission().getTime()));
				updated=true;

			}
			if (recette.getRapporteur() != null) {
				recette1.setRapporteur(recette.getRapporteur());
				updated=true;

			}if (recette.getMois() != null) {
				recette1.setMois(new Timestamp(recette.getMois().getTime()));
				updated=true;

			}if (recette.getPercepteur() != null) {
				recette1.setPercepteur(recette.getPercepteur());
				updated=true;

			}
			if (recette.getEmetteur() != null) {
				recette1.setEmetteur(recette.getEmetteur());
				updated=true;


			}if (recette.getEmetteur() != null) {
				recette1.setEmetteur(recette.getEmetteur());
				updated=true;

			}if (recette.getCommentaire() != null) {
						recette1.setCommentaire(recette.getCommentaire());
						updated=true;

			}if (!Double.isNaN(recette.getRecetteBrut())) {
				recette1.setRecetteBrut(recette.getRecetteBrut());
				updated=true;
			}if (!Double.isNaN(recette.getRecetteNet())) {
				recette1.setRecetteNet(recette.getRecetteNet());
				updated=true;
			}
			if (!Double.isNaN(recette.getCharge())) {
				recette1.setCharge(recette.getCharge());
				updated=true;
			}
			if (!Double.isNaN(recette.getTonnage())) {
				recette1.setTonnage(recette.getTonnage());
				updated=true;
			}
		}

		if(updated) {
			sessionFactory.getCurrentSession().update(recette1);
		}else{
			recette1=null;
		}

		return recette1;
	}

	public List<Recette> getAllRecettes(){
		List<Recette> recettes = new ArrayList<Recette>();


		recettes = sessionFactory.getCurrentSession().createQuery("from Recette" ).list();

		if (recettes.size() > 0) {
			return recettes;
		} else {
			return null;
		}

	}

	public List<RecetteDto> get30(){

		List<Recette> recettes = new ArrayList<Recette>();


		recettes = sessionFactory.getCurrentSession().createQuery("from Recette" ).list();

		List<RecetteDto> recettedto = new ArrayList<RecetteDto>();
		int i;

		if(recettes.size()>=0) {
			for (i = 0; i < recettes.size(); i++) {
				recettedto.add(new RecetteDto(recettes.get(i)));
			}

		}else{
			recettedto=null;


		}
			return recettedto;

	}

}