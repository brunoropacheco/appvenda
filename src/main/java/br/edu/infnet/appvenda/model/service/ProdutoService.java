package br.edu.infnet.appvenda.model.service; //camada de servico

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Produto;

@Service //componnent - camada de servico
public class ProdutoService {

	private Map<Integer, Produto> mapaProduto = new HashMap<Integer, Produto>(); //ja cria o objeto e associa informacao a ele

	public void incluir(Produto produto) {
		mapaProduto.put(produto.getCodigo(), produto);
	}
	
	public Collection<Produto> obterLista(){	
		return mapaProduto.values();
	}
}