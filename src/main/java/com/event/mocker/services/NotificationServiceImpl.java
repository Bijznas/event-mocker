package com.event.mocker.services;

import com.event.mocker.daos.NotificationDao;
import com.event.mocker.entities.Notification;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * Created by sanjib on 2/5/17.
 */
public class NotificationServiceImpl implements NotificationService{

    @Inject
    private Validator validator;
    private Set<ConstraintViolation<Notification>> violations;

    @Inject
    private NotificationDao notificationDao;

    @Override
    public void save(Notification notification) throws MySQLIntegrityConstraintViolationException {
        violations = validator.validate(notification, Notification.class);
        if(violations.size() > 0){
            throw new ConstraintViolationException(violations);
        } else{
            notificationDao.save(notification);
        }
    }

    @Override
    public List<Notification> getAll() {
        return notificationDao.getAll();
    }
}
