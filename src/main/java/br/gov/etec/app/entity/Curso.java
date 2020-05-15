package br.gov.etec.app.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;


@Entity
@Table(name = "tb_curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_curso", nullable = false)
	private Long id;
	
	@Column(name = "nome_curso", nullable = false)
	private String nome;
	
	@Column(name = "nome_descricao", nullable = false)
	private String descricao;
	
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Curso [id=" + ", nome=" + nome + ", descricao=" + descricao + "]";
	}
}
