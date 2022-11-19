package Group3.Group3prelims.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group3.Group3prelims.user.entity.User;
import Group3.Group3prelims.user.repository.IUserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private IUserRepository UserJpaRepository;
	
	public User saveUser(User user) {
		return UserJpaRepository.saveAndFlush(user);
	}
	public User updateUser(User user) {
		return UserJpaRepository.saveAndFlush(user);
	}
	public List<User> getAllUsers(){
		return UserJpaRepository.findAll();
	}
	public User getUser(Integer id) {
		return UserJpaRepository.findById(id).get();
	}
	
//	public User login(String username) {
//		
//	}
}
