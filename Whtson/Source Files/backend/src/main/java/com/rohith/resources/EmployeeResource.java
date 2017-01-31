package com.rohith.resources;

import com.rohith.databases.EmployeeDAO;
import com.rohith.databases.Entity.Employee;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class EmployeeResource {
    private EmployeeDAO employeeDAO;

    public EmployeeResource(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @POST
    public List<Employee> checkEmployeeExists(Employee employee){
        return this.employeeDAO.checkIfEmployeeExists(employee);
    }

}
