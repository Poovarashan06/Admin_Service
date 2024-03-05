package com.project.ShoppingMall;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminControllerClass {
@Autowired
private AdminServiceClass service;

//Retrieval
@GetMapping("/admin")
public List<AdminClass> list() {
	return service.listAll();
}
//Retrieve by Id
@GetMapping("/admin/{id}")
public ResponseEntity<AdminClass>get(@PathVariable Integer id){
	try {
		AdminClass admin = service.get(id);
		return new ResponseEntity<AdminClass>(admin,HttpStatus.OK);
	}
	catch (Exception e) {
	AdminClass admin = service.get(id);
	return new ResponseEntity<AdminClass>(admin,HttpStatus.NOT_FOUND);
}
}
//Create
@PostMapping("/admin")

public void add(@RequestBody AdminClass admin) {
		service.save(admin);
}
//RESTful API method for Update operation
@PutMapping("/admin/{id}")
public ResponseEntity<?> update(@RequestBody AdminClass admin, @PathVariable Integer id)
{
try
{
AdminClass existProduct = service.get(id);
service.save(admin);
return new ResponseEntity<>(HttpStatus.OK);
}
catch (Exception e)
{
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
//RESTful API method for Delete operation
@DeleteMapping("/admin/{id}")
public void delete(@PathVariable Integer id)
{
service.delete(id);
}
}
   
