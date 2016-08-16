package br.com.projeto.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {

	private EntityManagerFactory emf;

	/*
	 * se vc j� est� acostumado com Hibernate a ideia � a mesma do m�todo de
	 * fabrica que criamos para os Session que vem do SessionFactory Aqui temos
	 * apenas nomeclatura diferente, pense assim.
	 */
	public  EntityManager getEntityManager() {

		// responsavel pela persistencia
		return emf.createEntityManager();
	}

	public DAO() {
		// chamo ele de reprodutor da inst�ncia
		emf = Persistence.createEntityManagerFactory("sistema");

		/*
		 * o nome passado vem do arquivo persistence.xml que cont�m as configs
		 * para conex�o com o BD.
		 */
	}
}
