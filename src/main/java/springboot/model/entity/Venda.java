package springboot.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import springboot.model.jsonview.ClienteView;
import springboot.model.jsonview.VendaView;

@Entity
@Table(name = "VENDA")
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	@JsonView({ ClienteView.Vendas.class, VendaView.Public.class })
	private Long id;

	@Column(name = "valor")
	@JsonView({ ClienteView.Vendas.class, VendaView.Public.class })
	private BigDecimal valor;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonView(VendaView.Public.class)
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonView({ ClienteView.Vendas.class, VendaView.Public.class })
	private Produto produto;

	public Venda() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}