package br.com.projeto.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "musica")
public class MusicaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3986500459642969551L;

	/** The codigo. */
	@Id
	@GeneratedValue
	@Column(name = "CODIGO_MUSICA", nullable = false)
	private Long codigoMusica;
	
	/** The nome. */
	@Column(name = "NOME", nullable = false, length = 100)
	private String nome;
	
	/** The artista. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CODIGO_ARTISTA", referencedColumnName="CODIGO_ARTISTA")
	private ArtistaEntity artista;
	
	/** The duracao. */
	@Column(name = "DURACAO", nullable = false, length = 45)
	private String duracao;
	
	/** The genero. */
	@Column(name = "GENERO", length = 45)
	private String genero;


	/**
	 * @return the codigoMusica
	 */
	public Long getCodigoMusica() {
		return codigoMusica;
	}

	/**
	 * @param codigoMusica the codigoMusica to set
	 */
	public void setCodigoMusica(Long codigoMusica) {
		this.codigoMusica = codigoMusica;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the artista
	 */
	public ArtistaEntity getArtista() {
		return artista;
	}

	/**
	 * @param artista the artista to set
	 */
	public void setArtista(ArtistaEntity artista) {
		this.artista = artista;
	}

	/**
	 * @return the duracao
	 */
	public String getDuracao() {
		return duracao;
	}

	/**
	 * @param duracao the duracao to set
	 */
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	
}
