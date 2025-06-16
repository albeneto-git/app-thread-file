package br.com.appthreadfile.utils;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import br.com.appthreadfile.utils.JPAUtil;

public class JPAUtilTest {

	@Test
	public void deveConectar() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		System.out.println("Conectado");
		entityManager.close();
		System.out.println("Conexão fechada");
	}
}
