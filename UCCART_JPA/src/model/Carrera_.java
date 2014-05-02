package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-01T19:31:26.876-0600")
@StaticMetamodel(Carrera.class)
public class Carrera_ {
	public static volatile SingularAttribute<Carrera, String> carrCod;
	public static volatile SingularAttribute<Carrera, Integer> carrCredmax;
	public static volatile SingularAttribute<Carrera, String> carrNombre;
	public static volatile ListAttribute<Carrera, Padron> padrons;
	public static volatile ListAttribute<Carrera, Plan> plans;
	public static volatile ListAttribute<Carrera, Requisito> requisitos;
}
