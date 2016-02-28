package ind.darthin.information.dao.jpa;

import ind.darthin.information.dao.IUserDao;
import ind.darthin.information.pojo.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class UserDaoJpaImpl implements IUserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(User user) throws Exception {
		this.entityManager.persist(user);
	}

	@Override
	public void delete(long id) throws Exception {
		this.entityManager.remove(this.entityManager.find(User.class, id));
	}

	@Override
	public void update(User user) throws Exception {
		this.entityManager.merge(user);
	}

	@Override
	public User read(long id) throws Exception {
		return this.entityManager.find(User.class, id);
	}

	@Override
	public List<User> find() throws Exception {
		Query query = entityManager.createQuery("select u from User u");
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) query.getResultList();
		return users;
	}

}
