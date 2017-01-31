package com.rohith.databases;

import com.rohith.databases.Entity.VisitorLogRegistry;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface VisitorLogRegistryDAO {

    @SqlUpdate("INSERT INTO VisitorLogRegistry VALUES(:visitorName, :hostId, :entryTime, :exitTime)")
    int visitorEntryLog(@BindBean VisitorLogRegistry visitorLogRegistry);

    @SqlUpdate("UPDATE VisitorLogRegistry set ExitTime = :exitTime WHERE VisitorName = :visitorName AND HostId = :hostId AND ExitTime IS NULL")
    int visitorExitLog(@BindBean VisitorLogRegistry visitorLogRegistry);

    @SqlQuery("SELECT * FROM VisitorLogRegistry WHERE ExitTime IS NULL")
    List<VisitorLogRegistry> presentVisitorCount();

    @SqlQuery("SELECT * FROM VisitorLogRegistry WHERE VisitorName = :visitorName AND HostId = :hostId AND ExitTime IS NULL")
    List<VisitorLogRegistry> checkForVisitorPresent(@BindBean VisitorLogRegistry visitorLogRegistry);
}
