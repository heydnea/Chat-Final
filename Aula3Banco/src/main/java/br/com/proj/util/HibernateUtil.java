package br.com.proj.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateUtil {
	public static EntityManager getEntityManager(){
		
		return Persistence.createEntityManagerFactory("bdchat").createEntityManager();
		
	}
	
}
