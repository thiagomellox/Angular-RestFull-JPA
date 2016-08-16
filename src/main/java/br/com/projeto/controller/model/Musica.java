package br.com.projeto.controller.model;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import br.com.projeto.entity.MusicaEntity;

/**
 * The Class Musica.
 *
 * @author Thiago Mello
 */
public class Musica {

	/** The codigo. */
	private Long codigo;
	
	/** The nome. */
	private String nome;
	
	/** The artista. */
	private Artista artista;
	
	/** The duracao. */
	private String duracao;
	
	/** The genero. */
	private String genero;
	
	/**
	 * Instantiates a new musica.
	 */
	public Musica(){
		
	}
	
	/**
	 * Instantiates a new musica.
	 *
	 * @param entity the entity
	 */
	public Musica(MusicaEntity entity){
		
		
		setCodigo(entity.getCodigoMusica());
		setNome(entity.getNome());
		setDuracao(mascaraHora(entity.getDuracao()));
		setGenero(entity.getGenero());
		setArtista(new Artista(entity.getArtista()));
	}

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
	 * Gets the artista.
	 *
	 * @return the artista
	 */
	public Artista getArtista() {
		return artista;
	}

	/**
	 * Sets the artista.
	 *
	 * @param artista the artista to set
	 */
	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	/**
	 * Gets the duracao.
	 *
	 * @return the duracao
	 */
	public String getDuracao() {
		return duracao;
	}

	/**
	 * Sets the duracao.
	 *
	 * @param duracao the duracao to set
	 */
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	/**
	 * Gets the genero.
	 *
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Sets the genero.
	 *
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * Mascara hora.
	 *
	 * @param value the value
	 * @return the string
	 */
	private String mascaraHora(String value){
		try {
			MaskFormatter mf = new MaskFormatter("##:##");
			mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(value);
		} catch (ParseException e) {}
		
		return value;
	}
	
}
