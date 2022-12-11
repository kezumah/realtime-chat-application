package com.example.distributedtexteditor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.distributedtexteditor.model.User;
import com.example.distributedtexteditor.service.UserService;

import java.util.ArrayList;

@RestController
public class AppServerController {

	@Autowired
	private UserService userService;
	
    /*
    This is the default test route - to be removed
     */
    @RequestMapping("/greeting")
    public String getGreeting() {
        return "Hello, world!";
    }

    /**
     Fetches the doc corresponding to a given hash from the database
     @param hash     the unique 4-letter key string that corresponds to the doc
     @return    an array representing the doc, or "ERROR" if no such doc exists in the database
     */
    @RequestMapping(value = "/doc", method = RequestMethod.POST)
    public ArrayList<String> postMethod(@RequestBody String hash) {
        ArrayList<String> doc = DatabaseController.getDocFromDatabase(hash);
        return doc;
    }

    /**
    Creates a new doc by generating a random hash and calling the database
    @return     the unique 4-letter key string that corresponds to the doc
     */
    @RequestMapping("/new")
    public String newDoc() {
        String hash = UtilityMethods.generateRandomHash();
        DatabaseController.createHashInDatabase(hash);
        return hash;
    }
    
    @PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {
		return userService.createUsers(users);
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}
	
	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUserById(id);
	}

}