package EntityBeans;

import EntityBeans.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-06T08:52:41")
@StaticMetamodel(ResignationRequest.class)
public class ResignationRequest_ { 

    public static volatile SingularAttribute<ResignationRequest, Integer> id;
    public static volatile SingularAttribute<ResignationRequest, Users> userID;
    public static volatile SingularAttribute<ResignationRequest, String> employeeNum;
    public static volatile SingularAttribute<ResignationRequest, String> nationalID;
    public static volatile SingularAttribute<ResignationRequest, String> name;
    public static volatile SingularAttribute<ResignationRequest, String> notes;

}