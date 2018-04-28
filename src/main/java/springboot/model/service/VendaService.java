package springboot.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import springboot.model.entity.Venda;

public interface VendaService {

	public Page<Venda> findAll(Pageable pageable);

	public Venda save();

}
