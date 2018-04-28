package springboot.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import springboot.model.jsonview.ClienteView;
import springboot.model.jsonview.VendaView;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	@JsonView({ ClienteView.Public.class, VendaView.Public.class })
	private Long id;

	@JsonView({ ClienteView.Public.class, VendaView.Public.class })
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonView({ ClienteView.Public.class, VendaView.Public.class })
	private Status status;

	@OneToMany(mappedBy = "cliente")
	@JsonView({ ClienteView.Public.class, VendaView.Public.class })
	private Set<Endereco> enderecos;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	@JsonView(ClienteView.Vendas.class)
	private Set<Venda> vendas;

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setCliente(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setCliente(null);

		return endereco;
	}

	public Set<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}

	public Venda addVenda(Venda venda) {
		getVendas().add(venda);
		venda.setCliente(this);

		return venda;
	}

	public Venda removeVenda(Venda venda) {
		getVendas().remove(venda);
		venda.setCliente(null);

		return venda;
	}

}