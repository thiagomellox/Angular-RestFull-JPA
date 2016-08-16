package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.entity.ArtistaEntity;


public interface ArtistaDAO {

	/**
	 * Save.
	 *
	 * @param Musica the musica
	 * @return the musica entity
	 */
	ArtistaEntity save(ArtistaEntity Musica);

	/**
	 * Delete.
	 *
	 * @param Musica the musica
	 */
	void delete(ArtistaEntity Musica);

	/**
	 * Update.
	 *
	 * @param Musica the musica
	 * @return the musica entity
	 */
	ArtistaEntity update(ArtistaEntity Musica);

	/**
	 * List all.
	 *
	 * @return the list
	 */
	List<ArtistaEntity> listAll();

	/**
	 * Find by name.
	 *
	 * @param nome the nome
	 * @return the list
	 */
	List<ArtistaEntity> findByName(String nome);

}
