package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-23T19:30:10.600-0600")
@StaticMetamodel(Beca.class)
public class Beca_ {
	public static volatile SingularAttribute<Beca, String> becaIdestudiante;
	public static volatile SingularAttribute<Beca, Date> becaInicio;
	public static volatile SingularAttribute<Beca, Integer> becaPorcentaje;
	public static volatile SingularAttribute<Beca, Integer> becaTipo;
	public static volatile SingularAttribute<Beca, Date> becaVencimiento;
	public static volatile SingularAttribute<Beca, Estudiante> estudiante;
}
