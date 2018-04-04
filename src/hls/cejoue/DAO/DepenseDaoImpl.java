package hls.cejoue.DAO;

import hls.cejoue.dto.DepenseDto;
import hls.cejoue.model.Depense;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class DepenseDaoImpl implements DepenseDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Depense findById(int id) {

		List<Depense> depenses = new ArrayList<Depense>();

		depenses = sessionFactory.getCurrentSession().createQuery("from Depense where id=?").setParameter(0, id)
				.list();

		if (depenses.size() > 0) {
			return depenses.get(0);
		} else {
			return null;
		}

	}
	public DepenseDto deleteDepense (DepenseDto depense){
		Depense depense1=	findById(depense.getId());
		DepenseDto depenseX=null;

		if (depense1!= null) {
			sessionFactory.getCurrentSession().delete(depense1);
			depenseX= new DepenseDto();
		}
		return depenseX;
	}
	public Depense createDepense (DepenseDto depense){
		Depense depense1=	findById(depense.getId());

		if (depense1== null) {
			depense1 = new Depense(depense.getType()  ,depense.getDateEffective() ,depense.getMontant()   ,depense.getRapporteur()  ,depense.getEmetteur()  ,depense.getCommentaire()  );
			sessionFactory.getCurrentSession().save(depense1);
		}else{
            return null;
        }

		return depense1;
	}

	public  Depense updateDepense(DepenseDto depense) {

		boolean updated=false ;
		Depense depense1 = findById(depense.getId());
		if (depense1 != null) {
			if (depense.getType() != null) {
				depense1.setType(depense.getType());
				updated=true;
				}
			if (depense.getDateEffective() != null) {
				depense1.setDateEffective(new Timestamp(depense.getDateEffective().getTime()));
				updated=true;

			}
			if (depense.getDateSoumission() != null) {
				depense1.setDateSoumission(new Timestamp(depense.getDateSoumission().getTime()));
				updated=true;

			}
			if (depense.getRapporteur() != null) {
				depense1.setRapporteur(depense.getRapporteur());
				updated=true;

			}if (depense.getEmetteur() != null) {
				depense1.setEmetteur(depense.getEmetteur());
				updated=true;

			}if (depense.getCommentaire() != null) {
				depense1.setCommentaire(depense.getCommentaire());
				updated=true;

			}
			if (!Double.isNaN(depense.getMontant())) {
				depense1.setMontant(depense.getMontant());
				updated=true;
			}
		}

		if(updated) {
			sessionFactory.getCurrentSession().save(depense1);
		}else{
            depense1=null;
        }

		return depense1;
	}

	public List<Depense> getAllDepenses(){
		List<Depense> depenses = new ArrayList<Depense>();


		depenses = sessionFactory.getCurrentSession().createQuery("from Depense" ).list();

		if (depenses.size() > 0) {
			return depenses;
		} else {
			return null;
		}

	}

    public List<DepenseDto> get30(){

        List<Depense> depenses = new ArrayList<Depense>();


        depenses = sessionFactory.getCurrentSession().createQuery("from Depense" ).list();

        List<DepenseDto> depensedto = new ArrayList<DepenseDto>();
        int i;

        if(depenses.size()>=0) {
            for (i = 0; i < depenses.size(); i++) {
                depensedto.add(new DepenseDto(depenses.get(i)));
            }

        }else{
            depensedto=null;


        }
        return depensedto;

    }


}