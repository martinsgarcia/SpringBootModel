package springboot.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.entity.Produto;
import springboot.model.service.ProdutoService;

@RestController
@RequestMapping(value = "/api/produtos", produces = "application/json")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Produto> findAll(Pageable pageable) throws Exception {

		return produtoService.findAll(pageable);

	}

}
