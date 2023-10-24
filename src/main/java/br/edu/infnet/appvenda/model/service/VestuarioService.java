package br.edu.infnet.appvenda.model.service; //camada de servico

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Vestuario;

@Service //componnent - camada de servico
public class VestuarioService {

	private Map<Integer, Vestuario> mapaVestuario = new HashMap<Integer, Vestuario>();

	public void incluir(Vestuario vestuario) {
		mapaVestuario.put(vestuario.getCodigo(), vestuario);
	}
	
	public Collection<Vestuario> obterLista(){	
		return mapaVestuario.values();
	}
}