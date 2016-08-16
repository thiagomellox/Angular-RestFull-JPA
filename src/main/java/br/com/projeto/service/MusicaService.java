package br.com.projeto.service;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.controller.model.Musica;
import br.com.projeto.dao.MusicaDAO;
import br.com.projeto.dao.impl.MusicaDAOImpl;
import br.com.projeto.entity.MusicaEntity;

public class MusicaService{

	MusicaDAO dao = new MusicaDAOImpl();

	public Musica save(Musica musica) {

		return new Musica(dao.save(musicaToEntity(musica)));
	}

	public void delete(Musica musica) {
		dao.delete(musicaToEntity(musica));
	}

	public Musica update(Musica musica) {
		return new Musica(dao.update(musicaToEntity(musica)));
	}

	public List<Musica> listAll() {
		List<Musica> list = new ArrayList<>();
		for(MusicaEntity entity: dao.listAll()){
			list.add(new Musica(entity));
		}
		return list;
	}

	public List<Musica> findByName(String nome) {
		List<Musica> list = new ArrayList<>();
		for(MusicaEntity entity: dao.findByName(nome)){
			list.add(new Musica(entity));
		}
		return list;
	}
	
	public List<Musica> findByNameAndArtista(String nome, Long codigoArtista) {
		List<Musica> list = new ArrayList<>();
		for(MusicaEntity entity: dao.findByNameAndArtista(nome, codigoArtista)){
			list.add(new Musica(entity));
		}
		return list;
	}
	
	private MusicaEntity musicaToEntity(Musica musica){
		MusicaEntity entity = new MusicaEntity();
		entity.setCodigoMusica(musica.getCodigo());
		entity.setNome(musica.getNome());
		entity.setDuracao(musica.getDuracao());
		entity.setGenero(musica.getGenero());
		entity.setArtista(ArtistaService.artistaToEntity(musica.getArtista()));
		return entity;
	}
}

