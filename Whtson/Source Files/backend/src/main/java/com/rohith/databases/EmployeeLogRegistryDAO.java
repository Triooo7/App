package com.rohith.databases;

import com.rohith.databases.Entity.EmployeeLogRegistry;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface EmployeeLogRegistryDAO {

    @SqlUpdate("INSERT into EmployeeLogRegistry Values(:personalNumber, :entryTime, :exitTime)")
    int employeeEntryLog(@BindBean EmployeeLogRegistry employeeLogRegistry);

    @SqlUpdate("UPDATE EmployeeLogRegistry set ExitTime = :exitTime where personalNumber = :personalNumber AND ExitTime IS NULL")
    int employeeExitLog(@BindBean EmployeeLogRegistry employeeLogRegistry);

    @SqlQuery("SELECT * from EmployeeLogRegistry WHERE ExitTime IS NULL")
    List<EmployeeLogRegistry> presentEmployeeCount();

    @SqlQuery("SELECT * FROM EmployeeLogRegistry WHERE personalNumber = :personalNumber AND ExitTime IS NULL")
    List<EmployeeLogRegistry> checkForEmployeePresent(@BindBean EmployeeLogRegistry employeeLogRegistry);
}
