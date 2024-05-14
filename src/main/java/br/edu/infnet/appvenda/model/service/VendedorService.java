package br.edu.infnet.appvenda.model.service; //camada de servico

import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.clients.IEnderecoClient;
import br.edu.infnet.appvenda.model.domain.Endereco;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;

@Service //componnent - camada de servico
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private IEnderecoClient enderecoClient;
	
	

	//private Map<String, Vendedor> mapaVendedor = new HashMap<String, Vendedor>(); //ja cria o objeto e associa informacao a ele

	public void incluir(Vendedor vendedor) {
		//vendedorRepository.save(vendedor);
		//mapaVendedor.put(vendedor.getCpf(), vendedor);
		Endereco endereco = enderecoClient.buscarCep(vendedor.getEndereco().getCep());
		
		vendedor.setEndereco(endereco);
		
		vendedorRepository.save(vendedor);
	}
	
	public Collection<Vendedor> obterLista(){
		return (Collection<Vendedor>) vendedorRepository.findAll();
		//return mapaVendedor.values();
	}
	
	public void excluir(Integer id) {
		vendedorRepository.deleteById(id);
	}
	
	public Vendedor pesquisar(String cpf) {
		return vendedorRepository.findByCpf(cpf);
	}
	
	public long obterQtde() {
		return vendedorRepository.count();
	}
}