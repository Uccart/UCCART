package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-07T15:25:31.769-0600")
@StaticMetamodel(Nota.class)
public class Nota_ {
	public static volatile SingularAttribute<Nota, NotaPK> id;
	public static volatile SingularAttribute<Nota, Integer> notaCondicion;
	public static volatile SingularAttribute<Nota, Integer> notaPromedio;
	public static volatile SingularAttribute<Nota, Curso> curso;
	public static volatile SingularAttribute<Nota, Estudiante> estudiante;
}
