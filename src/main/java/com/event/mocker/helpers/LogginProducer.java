package com.event.mocker.helpers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LogginProducer {

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint){
        //System.out.println(injectionPoint.getMember().getDeclaringClass().getName());
        return LogManager.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

}
