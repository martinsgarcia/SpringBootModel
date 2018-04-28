package springboot.model.bean;

public class ClienteBean {

	private Long id;

	private String nome;

	private StatusBean status;

	public ClienteBean() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusBean getStatus() {
		return status;
	}

	public void setStatus(StatusBean status) {
		this.status = status;
	}

}
