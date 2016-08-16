package br.com.projeto.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projeto.dao.ArtistaDAO;
import br.com.projeto.entity.ArtistaEntity;

public class ArtistaDAOImpl extends DAO implements ArtistaDAO {
	private EntityManager em;

	public ArtistaDAOImpl() {
		em = getEntityManager();
	}

	@Override
	public ArtistaEntity save(ArtistaEntity artista) {

		em.getTransaction().begin();
		em.persist(artista);
		em.getTransaction().commit();
		return artista;
	}

	@Override
	public void delete(ArtistaEntity artista) {
		em.getTransaction().begin();
		em.remove(em.contains(artista) ? artista : em.merge(artista));
		em.getTransaction().commit();
	}

	@Override
	public ArtistaEntity update(ArtistaEntity artista) {
		em.getTransaction().begin();
		em.merge(artista);
		em.getTransaction().commit();
		return artista;
	}

	@Override
	public List<ArtistaEntity> listAll() {
		StringBuilder query = new StringBuilder();
		query.append(" SELECT p FROM ArtistaEntity p");
		query.append(" order by p.nome");
		Query queryr = em.createQuery(query.toString());
		return queryr.getResultList();
	}


	@Override
	public List<ArtistaEntity> findByName(String nome) {
		StringBuilder query = new StringBuilder();
		query.append(" SELECT p FROM ArtistaEntity p");
		query.append(" WHERE upper(p.nome) like upper('%" + nome + "%')");
		query.append(" order by p.nome");
		Query queryr = em.createQuery(query.toString());
		return queryr.getResultList();
	}
}

