package com.orangezup.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.orangezup.entity.User;
import com.orangezup.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
@Api(value = "Users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Get All Users")
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> users = this.userService.findAll();

		return ResponseEntity.ok().body(users);
	}

	@ApiOperation(value = "Get One User")
	@GetMapping("/{id}")
	public ResponseEntity<User> findOne(@PathVariable(value = "id") Integer id) {
		User user = this.userService.findOne(id);

		return ResponseEntity.ok().body(user);
	}

	@ApiOperation(value = "Save User")
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody User dto) {
		
		User user = this.userService.save(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Update User")
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable(value = "id") Integer id, @RequestBody User dto) {
		this.userService.update(id, dto);

		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Delete User")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
		this.userService.delete(id);

		return ResponseEntity.noContent().build();
	}
}
