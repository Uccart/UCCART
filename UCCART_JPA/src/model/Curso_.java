package model;

import java.sql.Time;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-01T19:31:26.885-0600")
@StaticMetamodel(Curso.class)
public class Curso_ {
	public static volatile SingularAttribute<Curso, String> cursoId;
	public static volatile SingularAttribute<Curso, String> cursoAula;
	public static volatile SingularAttribute<Curso, Integer> cursoCantactual;
	public static volatile SingularAttribute<Curso, Integer> cursoCantmax;
	public static volatile SingularAttribute<Curso, Integer> cursoCantmin;
	public static volatile SingularAttribute<Curso, Integer> cursoDia1;
	public static volatile SingularAttribute<Curso, Time> cursoDia1final;
	public static volatile SingularAttribute<Curso, Time> cursoDia1inicio;
	public static volatile SingularAttribute<Curso, Integer> cursoDia2;
	public static volatile SingularAttribute<Curso, Time> cursoDia2final;
	public static volatile SingularAttribute<Curso, Time> cursoDia2inicio;
	public static volatile SingularAttribute<Curso, Date> cursoFinal;
	public static volatile SingularAttribute<Curso, Date> cursoInicio;
	public static volatile SingularAttribute<Curso, String> cursoSede;
	public static volatile SingularAttribute<Curso, Materia> materia;
	public static volatile SingularAttribute<Curso, Profesor> profesor;
	public static volatile ListAttribute<Curso, Nota> notas;
	public static volatile SingularAttribute<Curso, Periodo> periodo;
}
