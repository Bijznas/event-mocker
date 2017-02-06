package com.event.mocker.helpers;

import org.apache.log4j.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 * Created by sanjib on 8/6/16.
 */
@CrossOrigin
@Interceptor
public class CrossOriginInterceptor {

    @Inject
    private Logger logger;

    @Inject
    HttpServletRequest request;

    @AroundInvoke
    private Object intercept(InvocationContext invocationContext) throws Exception {

//        if(request.getHeader("Origin") != null) {
            return crossDomainResponse((Response) invocationContext.proceed(), "*");
//        } else {
//            return invocationContext.proceed();
//        }
    }

    public static Response crossDomainResponse(Response response, String origin) {
        if(origin != null) {
            return Response
                    .fromResponse(response)
                    .header("Access-Control-Allow-Origin", origin)
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Headers", "Content-Type")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .build();
        }
        return response;
    }
}
