package br.com.appthreadfile.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("appDespesasDB");

	public static EntityManager getEntityManager() {
		return fabrica.createEntityManager();
	}

}
