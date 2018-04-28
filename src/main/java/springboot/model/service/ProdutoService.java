package springboot.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import springboot.model.entity.Produto;

public interface ProdutoService {

	public Page<Produto> findAll(Pageable pageable);

}
