package com.event.mocker.resources;

import com.event.mocker.daos.ProcessDao;
import com.event.mocker.daos.TestDao;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
public class TestResource {

    @Inject
    ProcessDao processDao;

    @Inject
    Logger logger;


    @GET
    @Produces("text/plain")
    public String hello(){

        logger.info(">>>>" + new JSONArray(processDao.getAll()));
        return "hello";
    }
}
