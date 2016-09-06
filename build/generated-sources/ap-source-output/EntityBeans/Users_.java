package EntityBeans;

import EntityBeans.ResignationRequest;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-06T08:52:41")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> phone;
    public static volatile CollectionAttribute<Users, ResignationRequest> resignationRequestCollection;
    public static volatile SingularAttribute<Users, Integer> leavePermissiontimes;
    public static volatile SingularAttribute<Users, Integer> type;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> pictureID;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, String> username;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, String> salary;
    public static volatile SingularAttribute<Users, Integer> vacationBalance;
    public static volatile SingularAttribute<Users, String> notes;
    public static volatile SingularAttribute<Users, String> employenum;

}