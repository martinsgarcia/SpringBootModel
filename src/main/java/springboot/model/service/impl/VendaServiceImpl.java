package springboot.model.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import springboot.model.entity.Cliente;
import springboot.model.entity.Produto;
import springboot.model.entity.Venda;
import springboot.model.repository.ClienteRepository;
import springboot.model.repository.ProdutoRepository;
import springboot.model.repository.VendaRepository;
import springboot.model.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional(readOnly = true)
	@Override
	public Page<Venda> findAll(Pageable pageable) {
		return vendaRepository.findAll(pageable,
				EntityGraphUtils.fromAttributePaths("cliente", "cliente.status", "cliente.enderecos", "produto"));
	}

	@Transactional
	@Override
	public Venda save() {

		List<Produto> produtos = produtoRepository.findAll();
		List<Cliente> clientes = clienteRepository.findAll();

		if (produtos.isEmpty()) {
			throw new RuntimeException("Nenhum Produto cadastrado");
		}

		if (clientes.isEmpty()) {
			throw new RuntimeException("Nenhum Cliente cadastrado");
		}

		Venda venda = new Venda();
		venda.setCliente(clientes.get(0));
		venda.setProduto(produtos.get(0));
		venda.setValor(new BigDecimal(10.50));

		vendaRepository.save(venda);

		return venda;
	}

}
