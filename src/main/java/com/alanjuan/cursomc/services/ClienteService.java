package com.alanjuan.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alanjuan.cursomc.domain.Cliente;
import com.alanjuan.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new com.alanjuan.cursomc.services.exceptions.ObjectNotFoundException(
				 "Objeto não encontrado! id: " + id + ", Tipo: " + Cliente.class.getName(), null));
	
	}
			
}
