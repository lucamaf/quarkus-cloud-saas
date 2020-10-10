package org.acme;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

@Path("/api")
public class OrderResource {

    private Map<String, Order> orders = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(OrderResource.class);


    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/commitOrder")
    public Response add(Order order) {
        Random rand = new Random();
        int choice = rand.nextInt(4);
        if (choice == 0){
            LOG.info("!!!!!! SERVER ERROR !!!!!!");
            return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity("Service not available").build();
        }else{
            order.computeTrackingcode();
            orders.putIfAbsent(order.getId(), order);
            LOG.info("====== Committed order "+order.getId()+" ======");
            Reply r = new Reply(order.getId(), order.getTrackingcode(), ZonedDateTime.now().toString());
            return Response.status(Status.OK).entity(r).build();
        }        
    }

    @DELETE
    @Path("/deleteOrder/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("orderId") String orderId) {
        orders.remove(orderId);
        LOG.info("====== Deleted order "+orderId+" ======");
        return orderId;
    }
}