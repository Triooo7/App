package com.rohith.resources;

import com.rohith.databases.EmployeeLogRegistryDAO;
import com.rohith.databases.Entity.EmployeeLogRegistry;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("employeeLog")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class EmployeeLogRegistryResource {

    private EmployeeLogRegistryDAO employeeLogRegistryDAO;

    public EmployeeLogRegistryResource (EmployeeLogRegistryDAO employeeLogRegistryDAO){
        this.employeeLogRegistryDAO = employeeLogRegistryDAO;
    }

    @POST
    public int enterEmployeeLog(EmployeeLogRegistry employeeLogRegistry){
        List<EmployeeLogRegistry> list1 = this.employeeLogRegistryDAO.checkForEmployeePresent(employeeLogRegistry);
        if(list1.isEmpty()) {
            return this.employeeLogRegistryDAO.employeeEntryLog(employeeLogRegistry);
        }
        else{
            return 0;
        }
    }

    @PUT
    public int exitEmployeeLog(EmployeeLogRegistry employeeLogRegistry){
        return this.employeeLogRegistryDAO.employeeExitLog(employeeLogRegistry);
    }

    @GET
    public List<EmployeeLogRegistry> EmployeesPresent(){
        return this.employeeLogRegistryDAO.presentEmployeeCount();
    }

}
