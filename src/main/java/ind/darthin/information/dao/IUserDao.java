package ind.darthin.information.dao;

import java.util.List;

import ind.darthin.information.pojo.User;

public interface IUserDao {

	public void create(final User user) throws Exception;

	public void delete(final long id) throws Exception;

	public void update(final User user) throws Exception;

	public User read(final long id) throws Exception;

	public List<User> find() throws Exception;

}
