package com.event.mocker.daos;

import com.event.mocker.entities.Notification;
import com.event.mocker.entities.Process;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by sanjib on 2/5/17.
 */
public class NotificationDaoImpl implements NotificationDao {

    @Inject
    private EntityManager entityManager;

    @Override
    public void save(Notification notification) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(notification);
        tx.commit();
    }


    @Override
    public List<Notification> getAll() {
        TypedQuery<Notification> query = entityManager.createQuery("Select n from Notification n order by n.dateCreated desc", Notification.class);
        return query.getResultList();
    }


}
