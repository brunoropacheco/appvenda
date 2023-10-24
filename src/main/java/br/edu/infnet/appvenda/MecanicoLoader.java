package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Mecanico;
import br.edu.infnet.appvenda.model.service.MecanicoService;

@Order(4)
@Component
public class MecanicoLoader implements ApplicationRunner {
	
	@Autowired
	private MecanicoService mecanicoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/mecanico.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Mecanico mecanico = new Mecanico();

			mecanico.setCodigo(Integer.valueOf(campos[0]));
			mecanico.setDescricao(campos[1]);
			mecanico.setEstoque(Boolean.valueOf(campos[2]));
			mecanico.setPreco(Float.valueOf(campos[3]));
			mecanico.setMaterial(campos[4]);
			mecanico.setMaleavel(Boolean.valueOf(campos[5]));
			
			mecanicoService.incluir(mecanico);
			
			linha = leitura.readLine();
		}

		for(Mecanico mecanico: mecanicoService.obterLista()) {
			System.out.println("[Mecanico] " + mecanico);			
		}

		leitura.close();
	}
}