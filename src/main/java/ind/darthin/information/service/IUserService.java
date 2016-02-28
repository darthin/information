package ind.darthin.information.service;

import java.util.List;

import ind.darthin.information.pojo.User;

public interface IUserService {

	public void addUser(final User user) throws Exception;

	public void updateUser(final User user) throws Exception;

	public List<User> findUsers() throws Exception;

	public User getUserById(final long id) throws Exception;

	public void removeUser(final long id) throws Exception;

}
