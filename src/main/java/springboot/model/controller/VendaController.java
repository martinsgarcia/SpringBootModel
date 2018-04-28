package springboot.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import springboot.model.entity.Venda;
import springboot.model.jsonview.VendaView;
import springboot.model.jsonview.page.JsonPage;
import springboot.model.service.VendaService;

@RestController
@RequestMapping(value = "/api/vendas", produces = "application/json")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@RequestMapping(method = RequestMethod.GET)
	@JsonView(VendaView.Public.class)
	public Page<Venda> findAll(Pageable pageable) throws Exception {
		return new JsonPage<Venda>(vendaService.findAll(pageable), pageable);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Venda save() throws Exception {
		return vendaService.save();
	}

}
