package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Role;
import com.test.service.RoleService;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/getRoles")
	public ResponseEntity<List<Role>> getAllRoles(){
		
		List<Role> allRoles = roleService.getAllRoles();
		return new ResponseEntity<List<Role>>(allRoles, HttpStatus.OK);
	}
}
