package com.alanjuan.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alanjuan.cursomc.domain.Categoria;
import com.alanjuan.cursomc.repositories.CategoriaRepository;
import com.alanjuan.cursomc.services.exceptions.DataIntegrityException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new com.alanjuan.cursomc.services.exceptions.ObjectNotFoundException(
				 "Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName(), null));
	
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteById(Integer id){
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e ) {
			throw new DataIntegrityException("não é possivel excluir uma categoria que possui produto");
		}
	}
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
			PageRequest pageRequest =  PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
			return repo.findAll(pageRequest);
	}
	
}
