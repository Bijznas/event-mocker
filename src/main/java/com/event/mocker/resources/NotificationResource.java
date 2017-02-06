package com.event.mocker.resources;

import com.event.mocker.entities.Notification;
import com.event.mocker.entities.Process;
import com.event.mocker.helpers.CrossOrigin;
import com.event.mocker.services.NotificationService;
import com.event.mocker.services.ProcessService;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by sanjib on 2/5/17.
 */
@CrossOrigin
@Path("/notifications")
public class NotificationResource {

    @Inject
    Logger logger;

    @Inject
    NotificationService notificationService;

    @POST
    @Produces("application/json")
    public Response save(Notification notification){
        logger.info("Saving notifications : " + new JSONObject(notification));
        try {
            notificationService.save(notification);
            return Response.status(200).entity("").build();
        }catch (ConstraintViolationException | MySQLIntegrityConstraintViolationException ex){
            return Response.status(404).build();
        }catch (Exception e){
            return Response.status(500).build();
        }

    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        logger.info("Getting notifications.");
        try {
            return Response.status(200).entity(notificationService.getAll()).build();
        }catch (ConstraintViolationException ex){
            return Response.status(404).build();
        }catch (Exception ex){
            return Response.status(500).build();
        }

    }

}
