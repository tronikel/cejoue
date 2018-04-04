package hls.cejoue.DAO;

import java.util.ArrayList;
import java.util.List;

import hls.cejoue.dto.NewUserDto;
import hls.cejoue.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	public NewUserDto deleteUser(NewUserDto user) {
		User user1 = findByUserName(user.getUsername());
		NewUserDto userX = null;

		if (user1 != null) {
			sessionFactory.getCurrentSession().delete(user1);
			userX = new NewUserDto();
		}
		return userX;
	}

	public User createUser(NewUserDto user) {
		User user1 = findByUserName(user.getUsername());

		if (user1 == null) {
			user1 = new User(user.getUsername(), user.getPassword(), user.getEmail(), user.getNom(), user.getPrenom());
			sessionFactory.getCurrentSession().save(user1);
		}

		return user1;
	}

	public User updateUser(NewUserDto user) {
		boolean updated = false;
		User user1 = findByUserName(user.getUsername());
		if (user1 != null) {
			if (user.getEmail() != null) {
				user1.setEmail(user.getEmail());
				updated = true;
			}
			if (user.getNom() != null) {
				user1.setNom(user.getNom());
				updated = true;
			}
			if (user.getPrenom() != null) {
				user1.setPrenom(user.getPrenom());
				updated = true;
			}
		}
		if (updated) {
			sessionFactory.getCurrentSession().update(user1);
		} else {
			user1 = null;
		}


		return user1;
	}


	public User updatePassword(NewUserDto user) {
		User user1 = findByUserName(user.getUsername());

		if (user1 != null) {
			if (user.getPassword() == user1.getPassword()) {
				user1 = null;
			} else {
				user1.setPassword(user.getPassword());
			}
		}

		return user1;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User").list();

		if (users.size() > 0) {
			return users;
		} else {
			return null;
		}

	}

	public boolean checkUser(String username, String password) {
		List<User> users = new ArrayList<User>();
		boolean result = false;
		users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
				.list();

		if (users.size() == 1) {
			String pwd=users.get(0).getPassword();

			if (pwd.contentEquals(password)) {
				result = true;
			}
		}
		return result;
	}
}