package br.edu.infnet.appvenda.model.service; //camada de servico

import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;

@Service //componnent - camada de servico
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;

	//private Map<String, Vendedor> mapaVendedor = new HashMap<String, Vendedor>(); //ja cria o objeto e associa informacao a ele

	public void incluir(Vendedor vendedor) {
		vendedorRepository.save(vendedor);
		//mapaVendedor.put(vendedor.getCpf(), vendedor);
	}
	
	public Collection<Vendedor> obterLista(){
		return (Collection<Vendedor>) vendedorRepository.findAll();
		//return mapaVendedor.values();
	}
	
	public long obterQtde() {
		return vendedorRepository.count();
	}
}