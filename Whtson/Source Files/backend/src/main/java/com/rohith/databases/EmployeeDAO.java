package com.rohith.databases;

import com.rohith.databases.Entity.Employee;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface EmployeeDAO {

    @SqlQuery("SELECT * from EmployeeTable WHERE PersonalNumber = :personalNumber")
    List<Employee> checkIfEmployeeExists(@BindBean Employee employee);

}
