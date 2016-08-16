package br.com.projeto.service;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.controller.model.Artista;
import br.com.projeto.dao.ArtistaDAO;
import br.com.projeto.dao.impl.ArtistaDAOImpl;
import br.com.projeto.entity.ArtistaEntity;

public class ArtistaService{
	
	ArtistaDAO dao = new ArtistaDAOImpl();

	public Artista save(Artista artista) {

		return new Artista(dao.save(artistaToEntity(artista)));
	}

	public void delete(Artista artista) {
		dao.delete(artistaToEntity(artista));
	}

	public Artista update(Artista artista) {
		return new Artista(dao.update(artistaToEntity(artista)));
	}

	public List<Artista> listAll() {
		List<Artista> list = new ArrayList<>();
		for(ArtistaEntity entity: dao.listAll()){
			list.add(new Artista(entity));
		}
		return list;
	}


	public List<Artista> findByName(String nome) {
		List<Artista> list = new ArrayList<>();
		for(ArtistaEntity entity: dao.findByName(nome)){
			list.add(new Artista(entity));
		}
		return list;
	}
	
	public static ArtistaEntity artistaToEntity(Artista artista){
		ArtistaEntity entity = new ArtistaEntity();
		entity.setCodigoArtista(artista.getCodigo());
		entity.setNome(artista.getNome());
		entity.setNomeArtistico(artista.getNomeArtistico());
		return entity;
	}
}

