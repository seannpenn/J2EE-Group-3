package Group3.Group3prelims.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import Group3.Group3prelims.user.entity.User;


public interface IUserRepository extends JpaRepository<User, Integer>{
	public User findByEmail(String email);
	public User findByUsername(String username);
	
}