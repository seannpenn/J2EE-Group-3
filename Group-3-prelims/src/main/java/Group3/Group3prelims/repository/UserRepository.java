package Group3.Group3prelims.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Group3.Group3prelims.entity.User;


@Repository
public class UserRepository implements IUserRepository{
	@Autowired
	private JdbcTemplate template;
	public User findById(final int id)
	{
		final String sql = "SELECT * FROM user where user_id=?";
		final User result = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), id);
		
		return result;
	}
	public User findByEmail(final String email)
	{
		final String sql = "SELECT * FROM user where user_email=?";
		final User result = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), email);
		
		return result;
	}
	public List<User> findAll(){
		
		final String query = "SELECT * FROM user";
		final List<User> result = template.query(query, BeanPropertyRowMapper.newInstance(User.class));
		
		return result;
	}
	public int save(final User user) {
		final String sql = "INSERT INTO user (user_fname, user_lname, user_email, user_username, user_password) VALUES (?, ?, ?, ?, ?)";
		
		final int result = template.update(sql, user.getUser_fname(), user.getUser_lname(), user.getUser_email(), user.getUser_username(), user.getUser_password());
		
		return 3000;
	}
	public int updateByID(final User user) {
		return 0;
	}
	public int deleteByID(final int id) {
		return 0;
	}
}
