package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import br.edu.infnet.appvenda.model.domain.Vestuario;
import br.edu.infnet.appvenda.model.service.VestuarioService;

@Controller
public class VestuarioController {

	@Autowired
	private AppController appController;

	@Autowired
	private VestuarioService vestuarioService;

	/*
	@GetMapping(value = "/vestuario/pesquisar")
	public String pesquisar(Model model, String campoBusca) {

		Vestuario vestuario = vestuarioService.pesquisar(campoBusca);
		
		if(vestuario != null) {
			model.addAttribute("objeto", vestuario);
			return appController.showHome(model);
		}
		return "redirect:/vestuario/lista";
	}
	*/

	@GetMapping(value = "/vestuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		vestuarioService.excluir(id);

		return "redirect:/vestuario/lista";
	}

	@GetMapping(value = "/vestuario/lista")
	public String obterLista(Model model) {

		model.addAttribute("rota", "vestuario");
		model.addAttribute("titulo", "Vestuarios:");
		model.addAttribute("listagem", vestuarioService.obterLista());

		return appController.showHome(model);
	}
}