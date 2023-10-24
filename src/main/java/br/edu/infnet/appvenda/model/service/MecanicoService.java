package br.edu.infnet.appvenda.model.service; //camada de servico

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Mecanico;

@Service //componnent - camada de servico
public class MecanicoService {

	private Map<Integer, Mecanico> mapaMecanico = new HashMap<Integer, Mecanico>();

	public void incluir(Mecanico mecanico) {
		mapaMecanico.put(mecanico.getCodigo(), mecanico);
	}
	
	public Collection<Mecanico> obterLista(){	
		return mapaMecanico.values();
	}
}