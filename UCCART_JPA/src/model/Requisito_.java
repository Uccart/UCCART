package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-01T19:31:26.943-0600")
@StaticMetamodel(Requisito.class)
public class Requisito_ {
	public static volatile SingularAttribute<Requisito, Integer> reqCod;
	public static volatile SingularAttribute<Requisito, Boolean> reqTipo;
	public static volatile SingularAttribute<Requisito, Carrera> carrera;
	public static volatile SingularAttribute<Requisito, Materia> materia1;
	public static volatile SingularAttribute<Requisito, Materia> materia2;
}
