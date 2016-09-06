package EntityBeans;

import EntityBeans.Tasks;
import EntityBeans.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-06T08:52:41")
@StaticMetamodel(WorkSchedule.class)
public class WorkSchedule_ { 

    public static volatile SingularAttribute<WorkSchedule, Users> userID;
    public static volatile SingularAttribute<WorkSchedule, Date> timeOut;
    public static volatile SingularAttribute<WorkSchedule, Date> timein;
    public static volatile SingularAttribute<WorkSchedule, Tasks> tasks;
    public static volatile SingularAttribute<WorkSchedule, Date> date;
    public static volatile SingularAttribute<WorkSchedule, String> comments;
    public static volatile SingularAttribute<WorkSchedule, Integer> taskID;

}