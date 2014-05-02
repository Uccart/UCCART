package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-01T19:31:26.935-0600")
@StaticMetamodel(Plan.class)
public class Plan_ {
	public static volatile SingularAttribute<Plan, Integer> planCod;
	public static volatile SingularAttribute<Plan, Integer> planCiclo;
	public static volatile SingularAttribute<Plan, Carrera> carrera;
	public static volatile SingularAttribute<Plan, Materia> materia;
}
