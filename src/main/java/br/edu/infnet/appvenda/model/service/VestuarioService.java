package br.edu.infnet.appvenda.model.service; //camada de servico

import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Vestuario;
//import br.edu.infnet.appvenda.model.repository.ProdutoRepository; CtrlShiftO para deletar os nao usados
import br.edu.infnet.appvenda.model.repository.VestuarioRepository;

@Service //componnent - camada de servico
public class VestuarioService {
	
	@Autowired
	private VestuarioRepository vestuarioRepository;

	//private Map<Integer, Vestuario> mapaVestuario = new HashMap<Integer, Vestuario>();

	public void incluir(Vestuario vestuario) {
		//mapaVestuario.put(vestuario.getCodigo(), vestuario);
		vestuarioRepository.save(vestuario);
	}
	
	public Collection<Vestuario> obterLista(){	
		//return mapaVestuario.values();
		return (Collection<Vestuario>) vestuarioRepository.findAll();
	}
	
	public long obterQtde() {
		return vestuarioRepository.count();
	}
}