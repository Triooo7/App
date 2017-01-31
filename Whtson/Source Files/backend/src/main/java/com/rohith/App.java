package com.rohith;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import com.rohith.databases.EmployeeDAO;
import com.rohith.databases.EmployeeLogRegistryDAO;
import com.rohith.databases.Entity.EmployeeLogRegistry;
import com.rohith.databases.Entity.VisitorLogRegistry;
import com.rohith.databases.VisitorLogRegistryDAO;
import com.rohith.resources.EmployeeLogRegistryResource;
import com.rohith.resources.EmployeeResource;
import com.rohith.resources.VisitorLogRegistryResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class App extends Application<DatabaseConfiguration> {

    @Override
    public void run(DatabaseConfiguration configuration, Environment environment) throws Exception {


        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        environment.jersey().setUrlPattern("/api/*");


        final EmployeeDAO employeeDAO = jdbi.onDemand(EmployeeDAO.class);
        final VisitorLogRegistryDAO visitorLogRegistryDAO = jdbi.onDemand(VisitorLogRegistryDAO.class);
        final EmployeeLogRegistryDAO employeeLogRegistryDAO = jdbi.onDemand(EmployeeLogRegistryDAO.class);




        EmployeeResource employeeResource = new EmployeeResource(employeeDAO);
        VisitorLogRegistryResource visitorLogRegistryResource = new VisitorLogRegistryResource(visitorLogRegistryDAO);
        EmployeeLogRegistryResource employeeLogRegistryResource = new EmployeeLogRegistryResource(employeeLogRegistryDAO);



        environment.jersey().register(employeeResource);
        environment.jersey().register(visitorLogRegistryResource);
        environment.jersey().register(employeeLogRegistryResource);

    }

    @Override
    public void initialize(Bootstrap<DatabaseConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

}
