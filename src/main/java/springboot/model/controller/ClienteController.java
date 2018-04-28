package springboot.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import springboot.model.bean.ClienteBean;
import springboot.model.entity.Cliente;
import springboot.model.jsonview.ClienteView;
import springboot.model.jsonview.page.JsonPage;
import springboot.model.service.ClienteService;

@RestController
@RequestMapping(value = "/api/clientes", produces = "application/json")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	@JsonView(ClienteView.Public.class)
	public Page<Cliente> findAll(Pageable pageable) throws Exception {
		return new JsonPage<Cliente>(clienteService.findAll(pageable), pageable);
	}

	@PreAuthorize("hasRole('TESTE2')")
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	@JsonView(ClienteView.Public.class)
	public Page<Cliente> findAll2(Pageable pageable) throws Exception {
		return new JsonPage<Cliente>(clienteService.findAll(pageable), pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@JsonView(ClienteView.Public.class)
	public Cliente findAll(@PathVariable(name = "id") Long id) throws Exception {
		return clienteService.findById(id);
	}

	@RequestMapping(value = "/{id}/vendas", method = RequestMethod.GET)
	@JsonView(ClienteView.Vendas.class)
	public Cliente findClienteVendas(@PathVariable(name = "id") Long id) throws Exception {
		return clienteService.findClienteVendas(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Cliente create(@RequestBody ClienteBean clienteBean) throws Exception {
		return clienteService.create(clienteBean);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Cliente update(@RequestBody ClienteBean clienteBean) throws Exception {
		return clienteService.update(clienteBean);
	}

}
