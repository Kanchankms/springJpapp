package com.cg.payapp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil
{
	static EntityManagerFactory emFact=null;			//to establish connection with database
	static EntityManager entityManager=null;
	
	public static EntityManager getEntityManager()
	{
		emFact=Persistence.createEntityManagerFactory("JPA-PU-Oracle");
		entityManager=emFact.createEntityManager();
		return entityManager;
	}
}
