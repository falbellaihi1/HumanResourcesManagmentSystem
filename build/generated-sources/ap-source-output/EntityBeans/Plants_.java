package EntityBeans;

import EntityBeans.Labels;
import EntityBeans.Tasks;
import EntityBeans.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-06T08:52:41")
@StaticMetamodel(Plants.class)
public class Plants_ { 

    public static volatile SingularAttribute<Plants, String> tableNumber;
    public static volatile SingularAttribute<Plants, Users> userID;
    public static volatile SingularAttribute<Plants, Integer> plantID;
    public static volatile SingularAttribute<Plants, String> species;
    public static volatile SingularAttribute<Plants, Labels> labels;
    public static volatile SingularAttribute<Plants, String> tablePosition;
    public static volatile SingularAttribute<Plants, String> otherNotes;
    public static volatile SingularAttribute<Plants, String> genus;
    public static volatile CollectionAttribute<Plants, Tasks> tasksCollection;
    public static volatile SingularAttribute<Plants, String> pictureID;

}