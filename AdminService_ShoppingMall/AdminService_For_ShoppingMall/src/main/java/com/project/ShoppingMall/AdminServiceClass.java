package com.project.ShoppingMall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.*;

@Service
@Transactional
public class AdminServiceClass {
@Autowired
	private AdminRepository repository;

	public List<AdminClass> listAll(){
	return repository.findAll();	
	}
	public AdminClass get(Integer id) {
		return repository.findById(id).get();
	}
	public void save(AdminClass admin) {
		repository.save(admin);
	}
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
