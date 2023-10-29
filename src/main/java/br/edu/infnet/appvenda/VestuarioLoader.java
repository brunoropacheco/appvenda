package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.domain.Vestuario;
import br.edu.infnet.appvenda.model.service.VestuarioService;

@Order(3)
@Component
public class VestuarioLoader implements ApplicationRunner {
	
	@Autowired
	private VestuarioService vestuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/vestuario.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
		
		Vendedor vendedor = new Vendedor();
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Vestuario vestuario = new Vestuario();

			vestuario.setCodigo(Integer.valueOf(campos[0]));
			vestuario.setDescricao(campos[1]);
			vestuario.setEstoque(Boolean.valueOf(campos[2]));
			vestuario.setPreco(Float.valueOf(campos[3]));
			vestuario.setCor(campos[4]);
			vestuario.setTamanho(campos[5]);
			
			vendedor.setId(Integer.valueOf(campos[6]));
			
			vestuario.setVendedor(vendedor);
			
			vestuarioService.incluir(vestuario);
			
			linha = leitura.readLine();
		}

		for(Vestuario vestuario: vestuarioService.obterLista()) {
			System.out.println("[Vestuario] " + vestuario);			
		}

		leitura.close();
	}
}