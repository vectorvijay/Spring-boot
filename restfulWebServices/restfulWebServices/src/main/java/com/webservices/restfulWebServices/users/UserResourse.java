package com.webservices.restfulWebServices.users;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResourse {
	@Autowired //imp
	private UserDaoService service;	
	//retrieveAllUser
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//retrieveUserbyid
	@GetMapping("/users/{id}")
	public User retrieveUserById(@PathVariable int id) {
		User user =service.findone(id);
		if(user ==null) {
			throw new UserNotFoundException("id-"+id);
		}
		return user ;
		
	}
	@GetMapping("/sortedUsers")
	public List<User> SortedUsers() {
		return service.Ordered();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> Add(@RequestBody User user){
		User saveduser=service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
    @DeleteMapping("/users/{id}")
    public List<User> deleteUser(@PathVariable int id)
    {
    	if(service.findone(id)==null) {
    		throw new UserNotFoundException("id-"+id);
    		
    	}
    	
        return service.DeleteUser(id);
    }
    /*
     * http://localhost:8080/books?isbn=1234
    
    @GetMapping("/books/")
    public Book getBookDetails(@RequestParam("isbn") String isbn) {
    */
	
}
