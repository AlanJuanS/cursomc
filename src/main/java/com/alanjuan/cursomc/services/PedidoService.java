package com.alanjuan.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alanjuan.cursomc.domain.Pedido;
import com.alanjuan.cursomc.repositories.PedidoRepository;
import com.alanjuan.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! id: " + id + ", Tipo: " + Pedido.class.getName(), null));
	
	}
			
}
