package ind.darthin.information.dao.hibernate;

import ind.darthin.information.dao.IUserDao;
import ind.darthin.information.pojo.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDaoHibernateImpl implements IUserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(User user) throws Exception {
		this.sessionFactory.getCurrentSession().save(user);
	}

	public void delete(long id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, id);
		if (null != user) {
			session.delete(user);
		}
	}

	public void update(User user) throws Exception {
		this.sessionFactory.getCurrentSession().update(user);
	}

	public User read(long id) throws Exception {
		User user = (User) this.sessionFactory.getCurrentSession().load(User.class, id);
		return user;
	}

	public List<User> find() throws Exception {
		@SuppressWarnings("unchecked")
		List<User> result = this.sessionFactory.getCurrentSession().createQuery("from User").list();
		return result;
	}

	//	public void addPersonToEvent(Long userId, Long eventId) {
	//		User user = (User) session.load(User.class, userId);
	//		Event anEvent = (Event) session.load(Event.class, eventId);
	//		user.getEvents().add(anEvent);
	//	}
	//
	//	public void addEmailToPerson(Long userId, String email) {
	//		User user = (User) session.load(User.class, userId);
	//		user.getEmails().add(email);
	//	}

	//	public static void main(String[] args) throws Exception {
	//		UserHibernateDaoImpl userDao = new UserHibernateDaoImpl();
	//
	//		User user = new User("f", "f");
	//		user.setBirthday(Calendar.getInstance().getTime());
	//		userDao.create(user);
	//
	//		userDao.getSession().getTransaction().commit();
	//		HibernateUtil.getSessionFactory().close();
	//	}

}
