package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-07T15:25:31.765-0600")
@StaticMetamodel(Materia.class)
public class Materia_ {
	public static volatile SingularAttribute<Materia, String> materiaId;
	public static volatile SingularAttribute<Materia, String> materiaArea;
	public static volatile SingularAttribute<Materia, Integer> materiaCreditos;
	public static volatile SingularAttribute<Materia, Integer> materiaLab;
	public static volatile SingularAttribute<Materia, String> materiaNombre;
	public static volatile ListAttribute<Materia, Curso> cursos;
	public static volatile ListAttribute<Materia, Plan> plans;
	public static volatile ListAttribute<Materia, Requisito> requisitos1;
	public static volatile ListAttribute<Materia, Requisito> requisitos2;
}
