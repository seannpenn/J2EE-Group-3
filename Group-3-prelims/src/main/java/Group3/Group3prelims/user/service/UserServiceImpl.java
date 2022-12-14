package Group3.Group3prelims.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group3.Group3prelims.ticket.entity.Ticket;
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
		
		User existingUser = UserJpaRepository.findById(user.getUser_id()).get();
		
		existingUser.setUser_fname(user.getUser_fname());
		existingUser.setUser_lname(user.getUser_lname());
		existingUser.setUser_email(user.getUser_email());
		existingUser.setUser_username(user.getUser_username());
		existingUser.setUser_password(user.getUser_password());
		existingUser.setIs_logged_in(user.getIs_logged_in());
		existingUser.setRoles(user.getRoles());
		return UserJpaRepository.saveAndFlush(existingUser);
	}
	public List<User> getAllUsers(){
		return UserJpaRepository.findAll();
	}
	public User getUser(Integer id) {
		return UserJpaRepository.findById(id).get();
	}
	public User deleteUser(Integer id){
		User chosenUser = UserJpaRepository.findById(id).get();
		if(chosenUser != null) {
			UserJpaRepository.delete(chosenUser);
			return chosenUser;
		}
		
		return null;
	}
	
	public User findByEmail(String email) {
		return UserJpaRepository.findByEmail(email);
	}
	public User findByUserName(String username) {
		return UserJpaRepository.findByUsername(username);
	}
	public User userlogin(String userCred) {
		
		if(userCred.contains("@")) {
			return UserJpaRepository.findByEmail(userCred);
		}
		else if(!userCred.contains("@")){
			return UserJpaRepository.findByUsername(userCred);
		}
		return null;
	}
}
