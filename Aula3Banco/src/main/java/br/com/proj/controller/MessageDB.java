package br.com.proj.controller;


import java.util.List;

import javax.persistence.EntityManager;

import br.com.proj.model.Mensagem;
import br.com.proj.util.HibernateUtil;

public class MessageDB {

	EntityManager entityManager;
	
	public MessageDB(){
		
		entityManager = HibernateUtil.getEntityManager();
		
	}
	
	public boolean insertMessage(Mensagem message) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(message);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	//Seleciona tudo o que esta em mando e devolve uma lista de mensagem - Necessario essa tag emcima para não dar erro
	@SuppressWarnings("unchecked")
	public List<Mensagem> selectAll () {
		return entityManager.createQuery("FROM " + Mensagem.class.getName()).getResultList();
	}


}
