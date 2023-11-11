package br.edu.infnet.appvenda.model.service; //camada de servico

import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.ProdutoRepository;

@Service //componnent - camada de servico
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	//private Map<String, Produto> mapaProduto = new HashMap<String, Produto>(); //ja cria o objeto e associa informacao a ele

	public void incluir(Produto produto) {
		produtoRepository.save(produto);
		//mapaProduto.put(produto.getCpf(), produto);
	}
	
	public Collection<Produto> obterLista(){
		return (Collection<Produto>) produtoRepository.findAll();
		//return mapaProduto.values();
	}
	
	public Collection<Produto> obterLista(Vendedor vendedor){
		return (Collection<Produto>) produtoRepository.obterLista(vendedor.getId());
		//return mapaProduto.values();
	}
	
	public long obterQtde() {
		return produtoRepository.count();
	}
}