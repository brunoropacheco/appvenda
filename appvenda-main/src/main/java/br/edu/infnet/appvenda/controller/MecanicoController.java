package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import br.edu.infnet.appvenda.model.domain.Mecanico;
import br.edu.infnet.appvenda.model.service.MecanicoService;

@Controller
public class MecanicoController {

	@Autowired
	private AppController appController;

	@Autowired
	private MecanicoService mecanicoService;

	/*
	@GetMapping(value = "/mecanico/pesquisar")
	public String pesquisar(Model model, String campoBusca) {

		Mecanico mecanico = mecanicoService.pesquisar(campoBusca);
		
		if(mecanico != null) {
			model.addAttribute("objeto", mecanico);
			return appController.showHome(model);
		}
		return "redirect:/mecanico/lista";
	}
	*/

	@GetMapping(value = "/mecanico/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		mecanicoService.excluir(id);

		return "redirect:/mecanico/lista";
	}

	@GetMapping(value = "/mecanico/lista")
	public String obterLista(Model model) {

		model.addAttribute("rota", "mecanico");
		model.addAttribute("titulo", "Mecanicos:");
		model.addAttribute("listagem", mecanicoService.obterLista());

		return appController.showHome(model);
	}
}