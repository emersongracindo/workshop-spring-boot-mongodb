package com.emersongracindo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emersongracindo.workshopmongo.domain.User;
import com.emersongracindo.workshopmongo.dto.UserDTO;
import com.emersongracindo.workshopmongo.repository.UserRepository;
import com.emersongracindo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = findById(id); // aqui o nelio usou findOne
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
