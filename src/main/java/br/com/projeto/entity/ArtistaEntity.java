package br.com.projeto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artista")
public class ArtistaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3214615276088372595L;

	/** The codigo. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CODIGO_ARTISTA", nullable = false)
	private Long codigoArtista;
	
	@Column(name = "NOME_ARTISTICO", nullable = false, length = 100)
	private String nomeArtistico;
	
	/** The nome. */
	@Column(name = "NOME", length = 100)
	private String nome;
	
	@OneToMany(mappedBy = "artista")
	private List<MusicaEntity> listaMusicas;


	/**
	 * @return the codigoArtista
	 */
	public Long getCodigoArtista() {
		return codigoArtista;
	}

	/**
	 * @param codigoArtista the codigoArtista to set
	 */
	public void setCodigoArtista(Long codigoArtista) {
		this.codigoArtista = codigoArtista;
	}

	/**
	 * @return the nomeArtistico
	 */
	public String getNomeArtistico() {
		return nomeArtistico;
	}

	/**
	 * @param nomeArtistico the nomeArtistico to set
	 */
	public void setNomeArtistico(String nomeArtistico) {
		this.nomeArtistico = nomeArtistico;
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
	 * @return the listaMusicas
	 */
	public List<MusicaEntity> getListaMusicas() {
		return listaMusicas;
	}

	/**
	 * @param listaMusicas the listaMusicas to set
	 */
	public void setListaMusicas(List<MusicaEntity> listaMusicas) {
		this.listaMusicas = listaMusicas;
	}
	
	
}
