package springboot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaSpecificationExecutor;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQueryDslPredicateExecutor;

import springboot.model.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>, EntityGraphJpaRepository<Venda, Long>,
		EntityGraphJpaSpecificationExecutor<Venda>, EntityGraphQueryDslPredicateExecutor<Venda> {

}
