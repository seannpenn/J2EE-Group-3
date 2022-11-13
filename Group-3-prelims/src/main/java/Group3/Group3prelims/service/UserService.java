package Group3.Group3prelims.service;

import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import Group3.Group3prelims.entity.User;
import Group3.Group3prelims.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	private IUserRepository repository;
	private Gson gson;
	
	@Autowired
	public UserService(final IUserRepository repository)
	{
		this.repository = repository;
		this.gson = new Gson();
	}
	
	public String findById(final int id)
	{
		return gson.toJson(repository.findById(id));
	}
	public String findByEmail(final String email)
	{
		return gson.toJson(repository.findByEmail(email));
	}
	
	public String findAll()
	{
		return gson.toJson(repository.findAll());
	}
	
	public int save(final BufferedReader body)
	{
		//from just a simple requestBody, we transform it to a class using fromJson
		final User user = gson.fromJson(body, User.class);
		
		return repository.save(user);
	}
	
	public int update(final User user)
	{
		return repository.updateByID(user);
	}
	
	public int deleteById(final int id)
	{
		return repository.deleteByID(id);
	}
}
