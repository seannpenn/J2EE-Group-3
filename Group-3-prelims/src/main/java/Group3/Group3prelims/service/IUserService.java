package Group3.Group3prelims.service;

import java.io.BufferedReader;

import Group3.Group3prelims.entity.User;

public interface IUserService {
	public String findById(final int id);
	public String findByEmail(final String email);
	public String findAll();
	public int save(final BufferedReader body);
	public int update(final User user);
	public int deleteById(final int id);
}
