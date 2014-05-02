package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-01T19:31:26.947-0600")
@StaticMetamodel(Titulo.class)
public class Titulo_ {
	public static volatile SingularAttribute<Titulo, Integer> titCodigo;
	public static volatile SingularAttribute<Titulo, Integer> titAsiento;
	public static volatile SingularAttribute<Titulo, Integer> titFolio;
	public static volatile SingularAttribute<Titulo, Integer> titTomo;
	public static volatile SingularAttribute<Titulo, Estudiante> estudiante;
}
