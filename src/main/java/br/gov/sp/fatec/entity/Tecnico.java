package br.gov.sp.fatec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tecnico")
public class Tecnico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tecnico_id")
	private long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "fg_ativo")
	private boolean fgAtivo;

	public Tecnico() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isFgAtivo() {
		return fgAtivo;
	}

	public void setFgAtivo(boolean fgAtivo) {
		this.fgAtivo = fgAtivo;
	}

	public String getFgAtivoStr() {
		return fgAtivo ? "Sim" : "Não";
	}
}
