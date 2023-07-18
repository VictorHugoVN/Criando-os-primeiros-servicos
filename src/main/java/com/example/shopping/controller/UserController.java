package com.example.shopping.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.dto.UserDTO;

import jakarta.annotation.PostConstruct;

@RestController
public class UserController {
	
	@GetMapping("/")
	public String getMessage() {
		return "Spring Boot is working";
	}
	
	
	public static List<UserDTO> usuarios = new ArrayList<UserDTO>();
	
	@PostConstruct
	public void initiateList() {
		UserDTO userDTO = new UserDTO();
		userDTO.setName("Eduarda");
		userDTO.setCpf("123");
		userDTO.setEndereco("Rua a");
		userDTO.setEmail("eduarda@email.com");
		userDTO.setTelefone("1234-3454");
		userDTO.setDataCadastro(new Date(0));
		
		UserDTO userDTO2 = new UserDTO();
		userDTO2.setName("Luiz");
		userDTO2.setCpf("456");
		userDTO2.setEndereco("Rua b");
		userDTO2.setEmail("Luizzz@email.com");
		userDTO2.setTelefone("1234-3454");
		userDTO2.setDataCadastro(new Date(0));
		
		UserDTO userDTO3 = new UserDTO();
		userDTO3.setName("Bruno");
		userDTO3.setCpf("789");
		userDTO3.setEndereco("Rua c");
		userDTO3.setEmail("bruno@email.com");
		userDTO3.setTelefone("1234-3454");
		userDTO3.setDataCadastro(new Date(0));
		
		usuarios.add(userDTO);
		usuarios.add(userDTO2);
		usuarios.add(userDTO3);
		
		
	}
	
	@GetMapping("/users")
	public List<UserDTO> getUsers(){
		return usuarios;
	}
	
	@GetMapping("/users/{cpf}")
	public UserDTO getUsersFiltro(@PathVariable String cpf) {
		for(UserDTO userFilter: usuarios) {
			if(userFilter.getCpf().equals(cpf)) {
				return userFilter;
			}
		}
		return null;
	}
	
	@PostMapping("/newUser")
	public UserDTO inserir(@RequestBody UserDTO userDTO) {
		userDTO.setDataCadastro(new Date(0));
		usuarios.add(userDTO);
		return userDTO;
	}
	
	@DeleteMapping("/user/{cpf}")
	public boolean remover(@PathVariable String cpf) {
		for(UserDTO userFilter: usuarios) {
			if(userFilter.getCpf().equals(cpf)) {
				usuarios.remove(userFilter);
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	

}
