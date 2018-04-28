package springboot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaSpecificationExecutor;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQueryDslPredicateExecutor;

import springboot.model.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, EntityGraphJpaRepository<Produto, Long>,
		EntityGraphJpaSpecificationExecutor<Produto>, EntityGraphQueryDslPredicateExecutor<Produto> {

}
