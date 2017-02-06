package com.event.mocker.services;

import com.event.mocker.entities.Notification;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import java.util.List;

/**
 * Created by sanjib on 2/5/17.
 */
public interface NotificationService {
    void save(Notification process) throws MySQLIntegrityConstraintViolationException;

    List<Notification> getAll();
}
