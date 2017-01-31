package com.rohith.resources;

import com.rohith.databases.Entity.VisitorLogRegistry;
import com.rohith.databases.VisitorLogRegistryDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("visitorLog")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VisitorLogRegistryResource {

private VisitorLogRegistryDAO visitorLogRegistryDAO;

    public VisitorLogRegistryResource(VisitorLogRegistryDAO visitorLogRegistryDAO){
        this.visitorLogRegistryDAO = visitorLogRegistryDAO;
    }

    @POST
    public int enterVisitorLog(VisitorLogRegistry visitorLogRegistry){
        List<VisitorLogRegistry> list1 = this.visitorLogRegistryDAO.checkForVisitorPresent(visitorLogRegistry);
        if(list1.isEmpty()) {
            return this.visitorLogRegistryDAO.visitorEntryLog(visitorLogRegistry);
        }
        else{
            return 0;
        }
    }

    @PUT
    public int exitVisitorLog(VisitorLogRegistry visitorLogRegistry){
        return this.visitorLogRegistryDAO.visitorExitLog(visitorLogRegistry);
    }

    @GET
    public List<VisitorLogRegistry> EmployeesPresent(){
        return this.visitorLogRegistryDAO.presentVisitorCount();
    }


}
