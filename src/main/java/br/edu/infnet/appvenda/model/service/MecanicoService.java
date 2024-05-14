package br.edu.infnet.appvenda.model.service; //camada de servico

import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Mecanico;
//import br.edu.infnet.appvenda.model.domain.Vestuario;
import br.edu.infnet.appvenda.model.repository.MecanicoRepository;

@Service //componnent - camada de servico
public class MecanicoService {
	
	@Autowired
	private MecanicoRepository mecanicoRepository;

	//private Map<Integer, Mecanico> mapaMecanico = new HashMap<Integer, Mecanico>();

	public void incluir(Mecanico mecanico) {
		//mapaMecanico.put(mecanico.getCodigo(), mecanico);
		mecanicoRepository.save(mecanico);
	}
	
	public void excluir(Integer id) {
		mecanicoRepository.deleteById(id);
	}
	
	public Collection<Mecanico> obterLista(){	
		//return mapaMecanico.values();
		return (Collection<Mecanico>) mecanicoRepository.findAll();
	}
	
	public long obterQtde() {
		return mecanicoRepository.count();
	}
}