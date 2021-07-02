package br.generation.projetointegrador.redesocial.vitalArte.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_postagem")
public class Postagem {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Size(min = 2 , max = 100)
	private String titulo;
	
	
	
	@NotNull
	@Size(max = 1000)
	private String corpo;
	
	
	@Size(max = 255)
	private String hashtags;
	
	
	
	private int curtir;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora = new java.sql.Date(System.currentTimeMillis());
	
	
	@Size(max = 255)
	private String multimidia; 
	//introduzir objetos de relacionamento entre tabelas (Foreign Keys)


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getCorpo() {
		return corpo;
	}


	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}


	public String getHashtags() {
		return hashtags;
	}


	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}


	public int getCurtir() {
		return curtir;
	}


	public void setCurtir(int curtir) {
		this.curtir = curtir;
	}


	public Date getDatahora() {
		return datahora;
	}


	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}


	public String getMultimidia() {
		return multimidia;
	}


	public void setMultimidia(String multimidia) {
		this.multimidia = multimidia;
	}
	
	
	
	
	
	
}
