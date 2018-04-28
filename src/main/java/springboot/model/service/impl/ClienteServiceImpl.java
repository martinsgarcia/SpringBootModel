package springboot.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.querydsl.core.types.dsl.BooleanExpression;

import springboot.model.bean.ClienteBean;
import springboot.model.entity.Cliente;
import springboot.model.entity.QCliente;
import springboot.model.entity.QStatus;
import springboot.model.entity.Status;
import springboot.model.repository.ClienteRepository;
import springboot.model.repository.StatusRepository;
import springboot.model.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Transactional(readOnly = true)
	@Override
	public Page<Cliente> findAll(Pageable pageable) {

		return clienteRepository.findAll(pageable, EntityGraphUtils.fromAttributePaths("status"));
	}

	@Transactional(readOnly = true)
	@Override
	public Cliente findById(Long idCliente) {
		QCliente qCliente = QCliente.cliente;

		BooleanExpression expression = qCliente.id.eq(idCliente);

		return clienteRepository.findOne(expression, EntityGraphUtils.fromAttributePaths("status"));
	}

	@Transactional(readOnly = true)
	@Override
	public Cliente findClienteVendas(Long idCliente) {
		QCliente qCliente = QCliente.cliente;

		BooleanExpression expression = qCliente.id.eq(idCliente);

		Cliente cliente = clienteRepository.findOne(expression,
				EntityGraphUtils.fromAttributePaths("vendas", "status"));

		return cliente;
	}

	private void validate(boolean isUpdate, ClienteBean clienteBean) {
		if (clienteBean == null)
			throw new RuntimeException("Objeto Cliente obrigatorio");

		if (isUpdate && clienteBean.getId() == null)
			throw new RuntimeException("Campo Id obrigatorio");

		if (clienteBean.getNome() == null || clienteBean.getNome().trim().isEmpty())
			throw new RuntimeException("Campo Nome obrigatorio");
	}

	@Transactional
	@Override
	public Cliente create(ClienteBean clienteBean) {
		this.validate(false, clienteBean);
		return this.save(clienteBean, new Cliente());
	}

	@Transactional
	@Override
	public Cliente update(ClienteBean clienteBean) {
		this.validate(true, clienteBean);
		Cliente cliente = clienteRepository.findOne(clienteBean.getId());

		return this.save(clienteBean, cliente);
	}

	private Cliente save(ClienteBean clienteBean, Cliente cliente) {
		cliente.setNome(clienteBean.getNome());

		QStatus qStatus = QStatus.status;
		BooleanExpression expression;
		if (clienteBean.getStatus() == null || clienteBean.getStatus().getId() == null) {
			expression = qStatus.nome.equalsIgnoreCase("ATIVO");
		} else {
			expression = qStatus.id.eq(clienteBean.getStatus().getId());
		}

		Status status = statusRepository.findOne(expression);
		if (status == null) {
			throw new RuntimeException("Status do cliente nao encontrado");
		}

		cliente.setStatus(status);

		clienteRepository.save(cliente);

		return cliente;
	}

}
