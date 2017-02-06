package com.event.mocker.resources;

import com.event.mocker.daos.ProcessDao;
import com.event.mocker.entities.Process;
import com.event.mocker.helpers.CrossOrigin;
import com.event.mocker.services.ProcessService;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.json.Json;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by sanjib on 2/5/17.
 */
@CrossOrigin
@Path("/processes")
public class ProcessResource {

    @Inject
    Logger logger;

    @Inject
    ProcessService processService;

    @POST
    @Produces("application/json")
    public Response save(Process process){
        logger.info("Saving process : " + new JSONObject(process));
        try {
            processService.save(process);
            return Response.status(200).entity(process).build();
        }catch (ConstraintViolationException ex){
            return Response.status(404).build();
        }catch (Exception ex){
            return Response.status(500).build();
        }

    }

    @PUT
    @Produces("application/json")
    public Response update(Process process){
        logger.info("Updating process : " + new JSONObject(process));
        try {
            return Response.status(200).entity(processService.update(process)).build();
        }catch (ConstraintViolationException ex){
            return Response.status(404).build();
        }catch (Exception ex){
            return Response.status(500).build();
        }

    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        logger.info("Getting all processes.");
        try {
            return Response.status(200).entity(processService.getAll()).build();
        }catch (ConstraintViolationException ex){
            return Response.status(404).build();
        }catch (Exception ex){
            return Response.status(500).build();
        }

    }

    @GET
    @Produces("application/json")
    @Path("/count")
    public Response getProcessCount(){
        logger.info("Getting all process counts." + processService.getProcessCount());
        try {
            return Response.status(200).entity(processService.getProcessCount().toString()).build();
        }catch (ConstraintViolationException ex){
            return Response.status(404).build();
        }catch (Exception ex){
            return Response.status(500).build();
        }

    }

    @OPTIONS
    public Response options() {
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
