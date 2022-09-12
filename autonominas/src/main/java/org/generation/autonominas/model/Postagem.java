package org.generation.autonominas.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O título é obrigatório!")
	@Size(min = 5, max = 100, message = "O título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;
	
	@NotNull(message = "O conteúdo é obrigatório!")
	private String conteudo;
	
	@UpdateTimestamp
	private LocalDateTime data_post;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public LocalDateTime getData_post() {
		return data_post;
	}

	public void setData_post(LocalDateTime data_post) {
		this.data_post = data_post;
	}
	
}
