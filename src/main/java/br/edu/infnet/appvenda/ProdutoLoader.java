package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;
//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Mecanico;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.domain.Vestuario;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Order(2)
@Component //para essa classe ser chamada qnd rodar a aplicacao
public class ProdutoLoader implements ApplicationRunner{
	
	@Autowired //so constroi o objeto abaixo quando nao existe um criado
	private ProdutoService produtoService;
	
	@Autowired //so constroi o objeto abaixo quando nao existe um criado
	private VendedorService vendedorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		FileReader file = new FileReader("files/produtos.txt"); // abriu o arquivo
		BufferedReader leitura = new BufferedReader(file); // leu o arquivo
		
		String linha = leitura.readLine();

		String[] campos = null;
		
		Vendedor vendedor = new Vendedor();

		while(linha != null) {
			
			campos = linha.split(";");
			
			switch (campos[6]) {
			case "M":
				Mecanico mecanico = new Mecanico();
				mecanico.setCodigo(Integer.valueOf(campos[0]));
				mecanico.setDescricao(campos[1]);
				mecanico.setEstoque(Boolean.valueOf(campos[2]));
				mecanico.setPreco(Float.valueOf(campos[3]));
				mecanico.setMaterial(campos[4]);
				mecanico.setMaleavel(Boolean.valueOf(campos[5]));
				
				vendedor.setId(Integer.valueOf(campos[7]));
				
				mecanico.setVendedor(vendedor);
				
				produtoService.incluir(mecanico);
				
				break;

			case "V":
				Vestuario vestuario = new Vestuario();
				vestuario.setCodigo(Integer.valueOf(campos[0]));
				vestuario.setDescricao(campos[1]);
				vestuario.setEstoque(Boolean.valueOf(campos[2]));
				vestuario.setPreco(Float.valueOf(campos[3]));
				vestuario.setCor(campos[4]);
				vestuario.setTamanho(campos[5]);
				
				vendedor.setId(Integer.valueOf(campos[7]));
				
				vestuario.setVendedor(vendedor);
				
				produtoService.incluir(vestuario);
				
				break;

			default:
				break;
			}
									
			linha = leitura.readLine();
		}
		
		for (Vendedor v : vendedorService.obterLista()) {
			for (Produto produto : produtoService.obterLista(v)) {
				System.out.println("[Produto] kkkkkk " + produto);
			}
		}
		
		leitura.close();
		
	}
	
	
}
