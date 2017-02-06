package com.event.mocker.helpers;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {

    // again, the container injects it
    @PersistenceContext
    private EntityManager em;

    // this will be in the request scope
    @Produces
//    @RequestScoped
    public EntityManager em() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testUnit");
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }

    public void dispose(@Disposes EntityManager em) {
        em.close();
    }

}
