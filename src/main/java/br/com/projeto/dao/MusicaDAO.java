package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.entity.MusicaEntity;


// TODO: Auto-generated Javadoc
/**
 * The Interface MusicaDAO.
 */
public interface MusicaDAO {

	/**
	 * Save.
	 *
	 * @param Musica the musica
	 * @return the musica entity
	 */
	MusicaEntity save(MusicaEntity Musica);

	/**
	 * Delete.
	 *
	 * @param Musica the musica
	 */
	void delete(MusicaEntity Musica);

	/**
	 * Update.
	 *
	 * @param Musica the musica
	 * @return the musica entity
	 */
	MusicaEntity update(MusicaEntity Musica);

	/**
	 * List all.
	 *
	 * @return the list
	 */
	List<MusicaEntity> listAll();

	/**
	 * Find by name.
	 *
	 * @param nome the nome
	 * @return the list
	 */
	List<MusicaEntity> findByName(String nome);

	/**
	 * Find by name and artista.
	 *
	 * @param nome the nome
	 * @param codigoArtista the codigo artista
	 * @return the list
	 */
	List<MusicaEntity> findByNameAndArtista(String nome, Long codigoArtista);

}
