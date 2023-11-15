package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.MecanicoService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;
import br.edu.infnet.appvenda.model.service.VestuarioService;


@Controller
public class AppController {
	//camada de controle que vai ser acessada por dentro do nosso projeto
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private VestuarioService vestuarioService;
	@Autowired
	private MecanicoService mecanicoService;
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	//@RequestMapping(value = "/", method = RequestMethod.POST)
	@GetMapping(value= "/")
	public String showHome(Model model) {
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde()); //criamos metodo no service para pegar dado do repository
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeVestuario", vestuarioService.obterQtde());
		model.addAttribute("qtdeMecanico", mecanicoService.obterQtde());
		
		return "home";
	}
	
	/* FOI PRA DENTRO DE VendedorController
	@GetMapping(value= "/vendedor/lista")
	public String obterListaVendedor(Model model) {
		
		model.addAttribute("titulo", "Vendedores:"); //esses nomes "listagem" estao no jsp
		model.addAttribute("listagem", vendedorService.obterLista()); //esses nomes "listagem" estao no jsp
		
		return showHome(model);
	}
	*/
	
	/* FOI PRA DENTRO DE ProdutoController
	@GetMapping(value= "/produto/lista")
	public String obterListaProduto(Model model) {
		
		model.addAttribute("titulo", "Produtos:"); //esses nomes "listagem" estao no jsp
		model.addAttribute("listagem", produtoService.obterLista()); //esses nomes "listagem" estao no jsp
		
		return showHome(model);
	}
	*/
	
	/*
	@GetMapping(value= "/vestuario/lista")
	public String obterListaVestuario(Model model) {
		
		model.addAttribute("titulo", "Vestuario:"); //esses nomes "listagem" estao no jsp
		model.addAttribute("listagem", vestuarioService.obterLista()); //esses nomes "listagem" estao no jsp
		
		return showHome(model);
	}
	*/
	
	/*
	@GetMapping(value= "/mecanico/lista")
	public String obterListaMecanico(Model model) {
		
		model.addAttribute("titulo", "Vestuario:"); //esses nomes "listagem" estao no jsp
		model.addAttribute("listagem", mecanicoService.obterLista()); //esses nomes "listagem" estao no jsp
		
		return showHome(model);
	}
	*/
}
