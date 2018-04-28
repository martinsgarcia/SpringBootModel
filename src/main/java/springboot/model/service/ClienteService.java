package springboot.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import springboot.model.bean.ClienteBean;
import springboot.model.entity.Cliente;

public interface ClienteService {

	public Page<Cliente> findAll(Pageable pageable);

	public Cliente findById(Long idCliente);

	public Cliente create(ClienteBean clienteBean);

	public Cliente update(ClienteBean clienteBean);

	public Cliente findClienteVendas(Long idCliente);

}
