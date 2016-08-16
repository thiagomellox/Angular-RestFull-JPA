package br.com.projeto.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projeto.dao.MusicaDAO;
import br.com.projeto.entity.MusicaEntity;


public class MusicaDAOImpl extends DAO implements MusicaDAO {
	
	private EntityManager em;

	public MusicaDAOImpl() {
		em = getEntityManager();
	}

	@Override
	public MusicaEntity save(MusicaEntity musica) {

		em.getTransaction().begin();
		em.persist(musica);
		em.getTransaction().commit();
		return musica;
	}

	@Override
	public void delete(MusicaEntity musica) {
		em.getTransaction().begin();
		em.remove(em.contains(musica) ? musica : em.merge(musica));
		em.getTransaction().commit();
	}

	@Override
	public MusicaEntity update(MusicaEntity musica) {
		em.getTransaction().begin();
		em.merge(musica);
		em.getTransaction().commit();
		return musica;
	}

	@Override
	public List<MusicaEntity> listAll() {
		StringBuilder query = new StringBuilder();
		query.append(" SELECT p FROM MusicaEntity p");
		query.append(" order by p.nome");
		Query queryr = em.createQuery(query.toString());
		return queryr.getResultList();
	}


	@Override
	public List<MusicaEntity> findByName(String nome) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT p FROM MusicaEntity p");
		sql.append(" WHERE upper(p.nome) like upper(:nome)");
		sql.append(" order by p.nome");
		
		Query queryr = em.createQuery(sql.toString());
		queryr.setParameter("nome", "%" + nome + "%");
		return queryr.getResultList();
	}
	
	@Override
	public List<MusicaEntity> findByNameAndArtista(String nome, Long codigoArtista) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT p FROM MusicaEntity p");
		sql.append(" WHERE upper(p.nome) like upper(:nome)");
		if(codigoArtista != null){
			sql.append(" AND p.artista.codigoArtista = :codigoArtista");
		}
		sql.append(" order by p.nome");
		
		Query queryr = em.createQuery(sql.toString());
		queryr.setParameter("nome", "%" + nome + "%");
		if(codigoArtista != null){
			queryr.setParameter("codigoArtista", codigoArtista);
		}
		return queryr.getResultList();
	}
}

