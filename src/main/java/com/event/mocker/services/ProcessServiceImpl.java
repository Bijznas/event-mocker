package com.event.mocker.services;

import com.event.mocker.daos.NotificationDao;
import com.event.mocker.daos.ProcessDao;
import com.event.mocker.entities.Notification;
import com.event.mocker.entities.Process;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.persistence.EntityTransaction;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * Created by sanjib on 2/5/17.
 */
public class ProcessServiceImpl implements ProcessService{

    @Inject
    private Validator validator;
    private Set<ConstraintViolation<Process>> violations;

    @Inject
    private ProcessDao processDao;

    @Inject
    private NotificationDao notificationDao;

    @Override
    public void save(Process process) {
        violations = validator.validate(process);
        if(violations.size() > 0){
            throw new ConstraintViolationException(violations);
        } else{
            processDao.save(process);
            Notification n = new Notification();
            n.setProcess(process);
            n.setTitle(String.format("A new instance of process(process_id : %d) created.", process.getId()));
            n.setDescription(String.format("A new %s process was created as the result of simulation.", process.getType().getValue()));
            notificationDao.save(n);
        }
    }

    @Override
    public Process update(Process process) {
        Process updatedProcess = processDao.update(process);

        Notification n = new Notification();
        n.setProcess(updatedProcess);
        n.setTitle("Process status changed.");
        n.setDescription(String.format("The status of Process(process_id : %s) has been changed to %s.", process.getId(), process.getStatus()));
        notificationDao.save(n);
        return updatedProcess;
    }

    @Override
    public List<Process> getAll() {
        return processDao.getAll();
    }

    @Override
    public JSONObject getProcessCount() {
        return processDao.getProcessCount();
    }
}
