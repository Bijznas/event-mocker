package com.event.mocker.daos;

import com.event.mocker.entities.Process;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * Created by sanjib on 2/5/17.
 */
public class ProcessDaoImpl implements ProcessDao {

    @Inject
    private EntityManager entityManager;

    @Override
    public void save(Process process) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(process);
        tx.commit();
    }

    @Override
    public Process update(Process process) {

        Process p = entityManager.find(Process.class, process.getId());
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        p.setStatus(process.getStatus());
        tx.commit();
        return p;
    }

    @Override
    public JSONObject getProcessCount() {

        Query queryUserProcessCount = entityManager.createQuery("SELECT count(*) FROM Process where status='Running' and type='USER'");
        Query querySystemProcessCount = entityManager.createQuery("SELECT count(*) FROM Process where status='Running' and type='SYSTEM'");

        JSONObject processCount = new JSONObject().put("system", (long) querySystemProcessCount.getSingleResult()).put("user", (long) queryUserProcessCount.getSingleResult());
        return processCount;
    }


    @Override
    public List<Process> getAll() {
        TypedQuery<Process> query = entityManager.createQuery("Select p from Process p order by p.lastUpdated desc", Process.class);
        return query.getResultList();
    }




}
