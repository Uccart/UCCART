package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-07T15:25:31.774-0600")
@StaticMetamodel(Padron.class)
public class Padron_ {
	public static volatile SingularAttribute<Padron, Integer> padSerial;
	public static volatile SingularAttribute<Padron, Carrera> carrera;
	public static volatile SingularAttribute<Padron, Estudiante> estudiante;
}
