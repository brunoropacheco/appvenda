package br.edu.infnet.appvenda.model.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.appvenda.model.domain.Vestuario;

@Repository
public interface VestuarioRepository extends CrudRepository<Vestuario,Integer> {
	
}
