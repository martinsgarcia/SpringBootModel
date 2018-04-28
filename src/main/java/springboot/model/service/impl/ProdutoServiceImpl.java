package springboot.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.model.entity.Produto;
import springboot.model.repository.ProdutoRepository;
import springboot.model.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional(readOnly = true)
	@Override
	public Page<Produto> findAll(Pageable pageable) {
		return produtoRepository.findAll(pageable);
	}

}
