package entity;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Date dataNascimento;
	
	public Cliente() {
	}

	public Cliente(Long id, String nome, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Clienite [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + "]";
	}

}
