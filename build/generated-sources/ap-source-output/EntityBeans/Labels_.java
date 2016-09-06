package EntityBeans;

import EntityBeans.Plants;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-06T08:52:41")
@StaticMetamodel(Labels.class)
public class Labels_ { 

    public static volatile SingularAttribute<Labels, Integer> plantID;
    public static volatile SingularAttribute<Labels, Plants> plants;
    public static volatile SingularAttribute<Labels, String> labelName;
    public static volatile SingularAttribute<Labels, String> additionalNotes;

}