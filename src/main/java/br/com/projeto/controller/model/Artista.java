package br.com.projeto.controller.model;

import br.com.projeto.entity.ArtistaEntity;

/**
 * The Class Artista.
 */
public class Artista {


	/** The codigo. */
	private Long codigo;
	
	/** The nome artistico. */
	private String nomeArtistico;
	
	/** The nome. */
	private String nome;

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 *
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the nome artistico.
	 *
	 * @return the nomeArtistico
	 */
	public String getNomeArtistico() {
		return nomeArtistico;
	}

	/**
	 * Sets the nome artistico.
	 *
	 * @param nomeArtistico the nomeArtistico to set
	 */
	public void setNomeArtistico(String nomeArtistico) {
		this.nomeArtistico = nomeArtistico;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	/**
	 * Instantiates a new artista.
	 */
	public Artista(){
		
	}
	
	/**
	 * Instantiates a new artista.
	 *
	 * @param entity the entity
	 */
	public Artista(ArtistaEntity entity){
		this.setCodigo(entity.getCodigoArtista());
		this.setNome(entity.getNome());
		this.setNomeArtistico(entity.getNomeArtistico());
		
	}
	
}
