package br.edu.infnet.appvenda.model.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.appvenda.model.domain.Mecanico;

@Repository
public interface MecanicoRepository extends CrudRepository<Mecanico,Integer> {
	
}
