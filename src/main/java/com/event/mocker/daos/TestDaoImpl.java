package com.event.mocker.daos;

import com.event.mocker.entities.Book;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by sanjib on 2/4/17.
 */
@Default
public class TestDaoImpl implements TestDao {

    @Inject
    private EntityManager entityManager;

    @Override
    public void print() {
        System.out.println(">>>>>>>>>>>>>>>>>OK");
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = entityManager.createQuery("Select b from Book b order by b.title", Book.class);
        return query.getResultList();
    }
}
