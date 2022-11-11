package Group3.Group3prelims.repository;

import java.util.List;

import Group3.Group3prelims.entity.User;


public interface IUserRepository {
	public User findById(final int id);
	public List<User> findAll(); 
	public int save(final User user);
	public int updateByID(final User user);
	public int deleteByID(final int id);
}
