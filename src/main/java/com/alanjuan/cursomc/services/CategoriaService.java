package com.alanjuan.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alanjuan.cursomc.domain.Categoria;
import com.alanjuan.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new com.alanjuan.cursomc.services.exceptions.ObjectNotFoundException(
				 "Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName(), null));
	
	}
			
}
