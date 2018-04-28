package springboot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaSpecificationExecutor;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQueryDslPredicateExecutor;

import springboot.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, EntityGraphJpaRepository<Cliente, Long>,
		EntityGraphJpaSpecificationExecutor<Cliente>, EntityGraphQueryDslPredicateExecutor<Cliente> {

}
