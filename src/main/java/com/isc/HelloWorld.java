package com.isc;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorld {

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input, @Context HttpServletRequest req) {
        StringBuilder stringBuilder = new StringBuilder();
        String remoteHost = req.getServerName();
        int remotePort = req.getServerPort();
        String host = "http://" + remoteHost + ":" + remotePort;
        stringBuilder.append("Server is running. ");
        stringBuilder.append("<a href=").append(host).append("/snaphelp/servlet").append("></a>").append("      ").append("<a href=").append(host).append("/snaphelp/servlet/ride/redirect").append("></a>");

        return stringBuilder.toString();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/jsonBean")
    public Response modifyJson(JsonBean input) {
        input.setVal2(input.getVal1());
        return Response.ok().entity(input).build();
    }
}

