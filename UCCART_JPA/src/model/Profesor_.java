package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-14T12:32:54.623-0600")
@StaticMetamodel(Profesor.class)
public class Profesor_ {
	public static volatile SingularAttribute<Profesor, String> profId;
	public static volatile SingularAttribute<Profesor, String> profApellido1;
	public static volatile SingularAttribute<Profesor, String> profApellido2;
	public static volatile SingularAttribute<Profesor, String> profCorreo;
	public static volatile SingularAttribute<Profesor, String> profGradoacademico;
	public static volatile SingularAttribute<Profesor, String> profNombre;
	public static volatile SingularAttribute<Profesor, String> profTelefono;
	public static volatile SingularAttribute<Profesor, Float> profSalario;
	public static volatile ListAttribute<Profesor, Curso> cursos;
}
