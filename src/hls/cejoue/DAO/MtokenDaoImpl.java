package hls.cejoue.DAO;


import hls.cejoue.dto.MtokenDto;
import hls.cejoue.model.Mtoken;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class MtokenDaoImpl implements MtokenDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Mtoken findByUserName(String username) {

		List<Mtoken> mtokens = new ArrayList<Mtoken>();

		mtokens = sessionFactory.getCurrentSession().createQuery("from Mtoken where username=? ORDER BY creationDate desc").setParameter(0, username)
				.list();

		if (mtokens.size() > 0) {
			return mtokens.get(0);
			// récupere le plus recnet
		} else {
			return null;
		}

	}
	public List <Mtoken> findAllByUserName(String username) {

		List<Mtoken> mtokens = new ArrayList<Mtoken>();

		mtokens = sessionFactory.getCurrentSession().createQuery("from Mtoken where username=? ORDER BY creationDate desc ").setParameter(0, username)
				.list();
// du plus recent au moins recent
		if (mtokens.size() > 0) {
			return mtokens;
		} else {
			return null;
		}

	}
	public Mtoken findById(String id) {

		List<Mtoken> mtokens = new ArrayList<Mtoken>();

		mtokens = sessionFactory.getCurrentSession().createQuery("from Mtoken where id=?").setParameter(0, id)
				.list();

		if (mtokens.size() > 0) {
			return mtokens.get(0);
		} else {
			return null;
		}

	}

	public Mtoken createMtoken (String username){
		List<Mtoken> mtokens=	findAllByUserName(username);
		Mtoken mtoken=mtokens.get(0);

		if (mtoken== null) {
			mtoken = new Mtoken(username);
			sessionFactory.getCurrentSession().save(mtoken);
		}

		return mtoken;
	}
	public Mtoken createMtoken (String username,String jsessionid){
		Mtoken mtoken=	findByUserName(username);

		if (mtoken== null|| mtoken.isExpired()) {
			mtoken = new Mtoken(username,jsessionid);
			System.out.println(mtoken.getId());

			sessionFactory.getCurrentSession().save(mtoken);
		}

		return mtoken;
	}

	public    Mtoken update(MtokenDto mtokenDto){
		Mtoken mtoken=	findByUserName(mtokenDto.getUsername());
		if (mtoken== null||mtoken.isExpired()) {

			System.out.println(mtoken.getId());

			sessionFactory.getCurrentSession().update(mtoken);
		}

		return mtoken;

	}


	public List<Mtoken> getAllMtokens(){
		List<Mtoken> mtokens = new ArrayList<Mtoken>();

		mtokens = sessionFactory.getCurrentSession().createQuery("from Mtoken " ).list();

		if (mtokens.size() > 0) {
			return mtokens;
		} else {
			return null;
		}

	}


}