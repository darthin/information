package ind.darthin.information.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ind.darthin.information.dao.IUserDao;
import ind.darthin.information.pojo.User;
import ind.darthin.information.service.IUserService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;

	public void setUserDao(final IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(final User user) throws Exception {
		this.userDao.create(user);
	}

	@Override
	public void updateUser(final User user) throws Exception {
		this.userDao.update(user);
	}

	@Override
	public List<User> findUsers() throws Exception {
		return this.userDao.find();
	}

	@Override
	public User getUserById(final long id) throws Exception {
		return this.userDao.read(id);
	}

	@Override
	public void removeUser(final long id) throws Exception {
		this.userDao.delete(id);
	}

}
