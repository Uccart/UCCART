package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-07T15:25:31.793-0600")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, String> usId;
	public static volatile SingularAttribute<Usuario, String> usNombre;
	public static volatile SingularAttribute<Usuario, String> usPw;
	public static volatile SingularAttribute<Usuario, Integer> usTipo;
}
