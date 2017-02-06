package com.event.mocker.daos;

import com.event.mocker.entities.Notification;

import java.util.List;

/**
 * Created by sanjib on 2/5/17.
 */
public interface NotificationDao {

    void save(Notification notification);

    List<Notification> getAll();
}
