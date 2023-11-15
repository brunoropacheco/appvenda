package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;
//import java.util.HashMap;
//import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

import br.edu.infnet.appvenda.model.domain.Endereco;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Order(1)
@Component //para essa classe ser chamada qnd rodar a aplicacao
public class VendedorLoader implements ApplicationRunner{
	
	@Autowired //so constroi o objeto abaixo quando nao existe um criado
	private VendedorService vendedorService;

	@Override
	//public void run(ApplicationArguments args) throws Exception {
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		FileReader file = new FileReader("files/vendedor.txt"); // abriu o arquivo
		BufferedReader leitura = new BufferedReader(file); // leu o arquivo
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			Vendedor vendedor = new Vendedor(); //o escopo dessa variavel eh so esse while
			//Endereco endereco = new Endereco(campos[3]);
			
			vendedor.setNome(campos[0]);
			vendedor.setCpf(campos[1]);
			vendedor.setEmail(campos[2]);
			vendedor.setEndereco(new Endereco(campos[3]));
			
			//vendedorService.incluir(vendedor);
			
			
			try {
				vendedorService.incluir(vendedor);
			} catch (ConstraintViolationException e) {
				FileLogger.logException("ERRO - [VENDEDOR] " + vendedor + " - " + e.getMessage());
				System.out.println("ERRO - [VENDEDOR] " + vendedor);
			}
							
			linha = leitura.readLine();
		}
		
		for(Vendedor vendedor: vendedorService.obterLista()) {
			System.out.println("[Vendedor] " + vendedor);			
		}
		
		leitura.close();
		
	}
	
	
}
