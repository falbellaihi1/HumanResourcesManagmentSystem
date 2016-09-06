package EntityBeans;

import EntityBeans.Plants;
import EntityBeans.WorkSchedule;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-06T08:52:41")
@StaticMetamodel(Tasks.class)
public class Tasks_ { 

    public static volatile SingularAttribute<Tasks, Date> startDate;
    public static volatile SingularAttribute<Tasks, Plants> plantID;
    public static volatile SingularAttribute<Tasks, WorkSchedule> workSchedule;
    public static volatile SingularAttribute<Tasks, String> otherNotes;
    public static volatile SingularAttribute<Tasks, Date> waterTime;
    public static volatile SingularAttribute<Tasks, Date> endDate;
    public static volatile SingularAttribute<Tasks, String> fertilizer;
    public static volatile SingularAttribute<Tasks, Integer> taskID;
    public static volatile SingularAttribute<Tasks, String> waterAmount;

}