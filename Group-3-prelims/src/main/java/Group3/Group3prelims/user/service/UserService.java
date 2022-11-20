package Group3.Group3prelims.user.service;

import Group3.Group3prelims.user.entity.User;
import java.util.List;

public interface UserService {
	public User saveUser(User user);
	public User updateUser(User user);
	public List<User> getAllUsers();
	public User getUser(Integer id);
	public User deleteUser(Integer id);
//	public User login(String username);
}
